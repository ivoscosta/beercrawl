package zx_ventures.com.beercrawl.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import zx_ventures.com.beercrawl.R;
import zx_ventures.com.beercrawl.data.Poc;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter mPresenter;
    private EditText mTextQuery;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);

        mTextQuery = (EditText) findViewById(R.id.textQuery);
        mListView = (ListView) findViewById(R.id.list);

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

        mListView.setAdapter(new ArrayAdapter<String>(
                this, R.layout.item_list_poc,
                R.id.name, mPocs));
    }

    @Override
    public void showPocs(Poc tasks) {
        Log.d("#####", "Shoooowwww");
    }
}
