package zx_ventures.com.beercrawl.productdetail;

import android.support.annotation.NonNull;

/**
 * Created by ivo on 27/08/17.
 */

public class ProductDetailPresenter implements ProductDetailContract.Presenter {

    private final ProductDetailContract.View mView;
    private ProductDetailActivity mActivity;

    public ProductDetailPresenter(@NonNull ProductDetailActivity activity) {
        mView = activity;
        mActivity = activity;
    }

    @Override
    public void start() {
    }
}
