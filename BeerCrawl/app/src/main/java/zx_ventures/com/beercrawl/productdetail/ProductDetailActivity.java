package zx_ventures.com.beercrawl.productdetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import zx_ventures.com.beercrawl.R;
import zx_ventures.com.beercrawl.data.PocCategorySearchQuery;
import zx_ventures.com.beercrawl.util.Util;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;
import static zx_ventures.com.beercrawl.productlist.ProductListActivity.PRODUCT;

public class ProductDetailActivity extends AppCompatActivity implements ProductDetailContract.View {

    private ProductDetailContract.Presenter mPresenter;
    private PocCategorySearchQuery.Product mProduct;
    private ImageView mPicture;
    private TextView mTitle, mPrice, mDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra(PRODUCT);
        mProduct = gson.fromJson(strObj, PocCategorySearchQuery.Product.class);

        mPicture = (ImageView) findViewById(R.id.picture);
        mTitle = (TextView) findViewById(R.id.title);
        mPrice = (TextView) findViewById(R.id.price);
        mDescription = (TextView) findViewById(R.id.description);

        mPresenter = new ProductDetailPresenter(this);
        showProduct(mProduct);
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
    public void showProduct(PocCategorySearchQuery.Product product) {
        PocCategorySearchQuery.ProductVariant item = product.productVariants().get(0);
        Util.setPicture(mPicture, item.imageUrl());
        mTitle.setText(item.title());
        mPrice.setText("R$" + item.price().toString().replace(".", ","));

        if(item.description() != null)
            mDescription.setText(item.description());
        else
            mDescription.setText(getResources().getString(R.string.no_description));
    }

    @Override
    public void setPresenter(ProductDetailContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
