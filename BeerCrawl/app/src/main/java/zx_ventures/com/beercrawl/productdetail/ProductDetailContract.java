package zx_ventures.com.beercrawl.productdetail;

import zx_ventures.com.beercrawl.BasePresenter;
import zx_ventures.com.beercrawl.BaseView;
import zx_ventures.com.beercrawl.data.PocCategorySearchQuery;

/**
 * Created by ivo on 27/08/17.
 */

public interface ProductDetailContract {

    interface View extends BaseView<Presenter> {
        void showProduct(PocCategorySearchQuery.Product product);
    }

    interface Presenter extends BasePresenter {

    }
}
