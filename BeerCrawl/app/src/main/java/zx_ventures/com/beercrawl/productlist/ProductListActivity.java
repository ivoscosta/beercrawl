package zx_ventures.com.beercrawl.productlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.util.List;

import zx_ventures.com.beercrawl.R;
import zx_ventures.com.beercrawl.data.AllCategoriesSearchQuery;
import zx_ventures.com.beercrawl.data.LocationMap;
import zx_ventures.com.beercrawl.data.PocCategorySearchQuery;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;
import static zx_ventures.com.beercrawl.home.MainActivity.POC;

public class ProductListActivity extends AppCompatActivity implements ProductListContract.View {

    private LocationMap mLocationMap;
    private TabLayout mTabLayout;
    private ProductListContract.Presenter mPresenter;
    private boolean mSelectOfLoad = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra(POC);
        mLocationMap = gson.fromJson(strObj, LocationMap.class);

        mPresenter = new ProductListPresenter(this, mLocationMap);

        getSupportActionBar().setTitle(mLocationMap.getFormattedAddress());

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //se for a primeira vez então ignora
                if(mSelectOfLoad == false) {
                    mSelectOfLoad = true;
                }
                else
                    mPresenter.getCategoryProducts(tab.getTag().toString());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mPresenter.start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showAllCategories(List<AllCategoriesSearchQuery.AllCategory> categories) {
        for(AllCategoriesSearchQuery.AllCategory item : categories) {
            TabLayout.Tab tab = mTabLayout.newTab();
            tab.setText(item.title());
            tab.setTag(item.id());
            mTabLayout.addTab(tab);
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setPresenter(@NonNull ProductListContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void showCategoryProducts(List<PocCategorySearchQuery.Product> products) {
        for(PocCategorySearchQuery.Product product : products) {
            if(product.productVariants().size() > 0) {
                Log.d("####", product.productVariants().get(0).title());
            }
        }
    }
}
