package zx_ventures.com.beercrawl.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import zx_ventures.com.beercrawl.R;
import zx_ventures.com.beercrawl.data.LocationMap;
import zx_ventures.com.beercrawl.productlist.ProductListActivity;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter mPresenter;
    private EditText mTextQuery;
    private ListView mListView;
    private ProgressBar mProgress;
    private LocationListAdapter mLocationListAdapter;
    private List<LocationMap> mLocationMapList;
    private List<String> mLocationListAddress;
    public static final String POC = "POC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);

        mTextQuery = (EditText) findViewById(R.id.textQuery);
        mListView = (ListView) findViewById(R.id.list);
        mProgress = (ProgressBar) findViewById(R.id.progress);

        mTextQuery.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 2)
                    mPresenter.searchLocation(s.toString().trim());
                else {
                    mLocationListAddress.clear();
                    mLocationListAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                goToLocation(mLocationMapList.get(position));
            }
        });

        mLocationListAddress = new ArrayList<>();
        mLocationListAdapter = new LocationListAdapter(mLocationListAddress, this);
        mListView.setAdapter(mLocationListAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showLocations(List<LocationMap> locationMaps) {
        mLocationMapList = locationMaps;
        mLocationListAddress.clear();
        for(int i = 0; i< locationMaps.size(); i++) {
            mLocationListAddress.add(mLocationMapList.get(i).getFormattedAddress());
        }
        mLocationListAdapter.notifyDataSetChanged();
    }

    @Override
    public void goToLocation(LocationMap locationMap) {
        Gson gson = new Gson();
        Intent intent = new Intent(getApplicationContext(), ProductListActivity.class);
        intent.putExtra(POC, gson.toJson(locationMap));
        startActivity(intent);
    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void setPresenter(@NonNull MainContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
