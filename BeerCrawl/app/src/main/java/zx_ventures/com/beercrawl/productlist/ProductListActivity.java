package zx_ventures.com.beercrawl.productlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import zx_ventures.com.beercrawl.R;
import zx_ventures.com.beercrawl.data.AllCategoriesSearchQuery;
import zx_ventures.com.beercrawl.data.LocationMap;
import zx_ventures.com.beercrawl.data.PocCategorySearchQuery;
import zx_ventures.com.beercrawl.productdetail.ProductDetailActivity;
import zx_ventures.com.beercrawl.util.Util;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;
import static zx_ventures.com.beercrawl.home.MainActivity.POC;

public class ProductListActivity extends AppCompatActivity implements ProductListContract.View {

    private LocationMap mLocationMap;
    private TabLayout mTabLayout;
    private ProductListContract.Presenter mPresenter;
    private boolean mSelectOfLoad = false;
    private RelativeLayout mProgress, mNoItens;
    private GridView mGridView;
    private ProductGridAdapter mProductsGridAdapter;
    private List<PocCategorySearchQuery.Product> mProducts;
    private TextView mTitleMessage, mTextMessage;
    public static final String PRODUCT = "PRODUCT";

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

        mProgress = (RelativeLayout) findViewById(R.id.progress);
        mNoItens = (RelativeLayout) findViewById(R.id.no_itens);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //se for a primeira vez então ignora
                if(mSelectOfLoad == false) {
                    mSelectOfLoad = true;
                }
                else {
                    mNoItens.setVisibility(View.GONE);
                    Util.crossfade(mGridView, mProgress);
                    mPresenter.getProducts(tab.getTag().toString());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        mGridView = (GridView) findViewById(R.id.gridview);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                PocCategorySearchQuery.Product product = mProducts.get(position);
                goToProduct(product);
            }
        });

        mTitleMessage = (TextView) findViewById(R.id.titleMessage);
        mTextMessage = (TextView) findViewById(R.id.textMessage);

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
        Util.crossfade(null, mTabLayout);
    }

    @Override
    public void setPresenter(@NonNull ProductListContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void showProducts(List<PocCategorySearchQuery.Product> products) {
        mProducts = products;
        mProductsGridAdapter = new ProductGridAdapter(this, mProducts);
        mGridView.setAdapter(mProductsGridAdapter);
        mNoItens.setVisibility(View.GONE);
        Util.crossfade(mProgress, mGridView);
    }

    @Override
    public void showMessageNoPocs() {
        mTitleMessage.setText(getResources().getString(R.string.no_pocs));
        mTextMessage.setText(getResources().getString(R.string.no_pocs_message));
        Util.crossfade(mProgress, mNoItens);
    }

    @Override
    public void showMessageNoProducts() {
        mTitleMessage.setText(getResources().getString(R.string.no_products));
        mTextMessage.setText(getResources().getString(R.string.no_products_message));
        Util.crossfade(mProgress, mNoItens);
    }

    @Override
    public void goToProduct(PocCategorySearchQuery.Product product) {
        Gson gson = new Gson();
        Intent intent = new Intent(getApplicationContext(), ProductDetailActivity.class);
        intent.putExtra(PRODUCT, gson.toJson(product));
        startActivity(intent);
    }
}
