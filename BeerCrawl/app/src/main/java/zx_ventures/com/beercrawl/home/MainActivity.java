package zx_ventures.com.beercrawl.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import zx_ventures.com.beercrawl.R;
import zx_ventures.com.beercrawl.data.Poc;
import zx_ventures.com.beercrawl.data.geocode.Result;
import zx_ventures.com.beercrawl.productlist.ProductListActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter mPresenter;
    private EditText mTextQuery;
    private ListView mListView;
    private ProgressBar mProgress;
    private PocListAdapter mPocListAdapter;
    private List<Result> mPocList;
    private List<String> mPocListAddress;
    public static final String POC = "POC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);

        mTextQuery = (EditText) findViewById(R.id.textQuery);
        mListView = (ListView) findViewById(R.id.list);
        mProgress = (ProgressBar) findViewById(R.id.progress);

        mTextQuery.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    mPresenter.searchPoc(mTextQuery.getText().toString().trim());
                    return false;
                }
                return false;
            }
        });

        mTextQuery.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 2)
                    mPresenter.searchPoc(s.toString().trim());
                else {
                    mPocListAddress.clear();
                    mPocListAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mPresenter.selectPoc(mPocList.get(position));
            }
        });

        mPocListAddress = new ArrayList<>();
        mPocListAdapter = new PocListAdapter(mPocListAddress, this);
        mListView.setAdapter(mPocListAdapter);
    }

    @Override
    public void showPocs(Poc tasks) {
        mPocListAddress.clear();
        mPocList = tasks.getResults();
        for(int i=0; i<tasks.getResults().size(); i++) {
            mPocListAddress.add(mPocList.get(i).getFormattedAddress());
        }
        mPocListAdapter.notifyDataSetChanged();
    }

    @Override
    public void goToPoc(Result poc) {
        Gson gson = new Gson();
        Intent intent = new Intent(getApplicationContext(), ProductListActivity.class);
        intent.putExtra(POC, gson.toJson(poc));
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
}
