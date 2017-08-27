package zx_ventures.com.beercrawl.productlist;

import java.util.List;

import zx_ventures.com.beercrawl.BasePresenter;
import zx_ventures.com.beercrawl.BaseView;
import zx_ventures.com.beercrawl.data.AllCategoriesSearchQuery;
import zx_ventures.com.beercrawl.data.LocationMap;
import zx_ventures.com.beercrawl.data.PocCategorySearchQuery;

/**
 * Created by ivo on 26/08/17.
 */

public interface ProductListContract {

    interface View extends BaseView<Presenter> {
        void showAllCategories(List<AllCategoriesSearchQuery.AllCategory> categories);
        void showCategoryProducts(List<PocCategorySearchQuery.Product> products);
//        void goToProduct(Beer product);
        void showProgress();
        void hideProgress();
    }

    interface Presenter extends BasePresenter {
        void getPoc(LocationMap location);
        void getAllCategories();
        void getCategoryProducts(String idCategory);
    }

}
