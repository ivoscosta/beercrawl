package zx_ventures.com.beercrawl.home;

import java.util.List;

import zx_ventures.com.beercrawl.BasePresenter;
import zx_ventures.com.beercrawl.BaseView;
import zx_ventures.com.beercrawl.data.LocationMap;

/**
 * Created by ivo on 24/08/17.
 */

public interface MainContract {

    interface View extends BaseView<Presenter> {
        void showLocations(List<LocationMap> locationMaps);
        void goToLocation(LocationMap locationMap);
        void showProgress();
        void hideProgress();
    }

    interface Presenter extends BasePresenter {
        void searchLocation(String query);
    }

}
