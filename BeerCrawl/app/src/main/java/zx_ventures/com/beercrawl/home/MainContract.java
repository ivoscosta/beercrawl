package zx_ventures.com.beercrawl.home;

import zx_ventures.com.beercrawl.data.Poc;
import zx_ventures.com.beercrawl.data.geocode.Result;

/**
 * Created by ivo on 24/08/17.
 */

public interface MainContract {

    interface View {
        void showPocs(Poc tasks);
        void goToPoc(Result poc);
        void showProgress();
        void hideProgress();
    }

    interface Presenter {
        void searchPoc(String query);
        void selectPoc(Result poc);
    }

}
