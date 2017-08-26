package zx_ventures.com.beercrawl.productlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

import zx_ventures.com.beercrawl.R;
import zx_ventures.com.beercrawl.data.geocode.Result;

import static zx_ventures.com.beercrawl.home.MainActivity.POC;

public class ProductListActivity extends AppCompatActivity {

    private Result mPoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra(POC);
        mPoc = gson.fromJson(strObj, Result.class);

        getSupportActionBar().setTitle(mPoc.getFormattedAddress());
    }
}
