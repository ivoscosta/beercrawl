package zx_ventures.com.beercrawl.home;

import java.util.List;

import zx_ventures.com.beercrawl.data.Poc;

/**
 * Created by ivo on 24/08/17.
 */

public interface MainContract {

    interface View{

        void showPocs(Poc tasks);

    }

    interface Presenter{

        void searchPoc(String query);
        void selectPoc();

    }

}
