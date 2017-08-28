package zx_ventures.com.beercrawl.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by ivo on 24/08/17.
 */

public class BeerCrawlApplication extends Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        BeerCrawlApplication.context = getApplicationContext();
    }

    //pega o contexto da aplicação
    public static Context getAppContext() {
        return BeerCrawlApplication.context;
    }
}
