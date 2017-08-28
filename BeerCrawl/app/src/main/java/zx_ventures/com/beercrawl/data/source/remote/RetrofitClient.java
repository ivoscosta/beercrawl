package zx_ventures.com.beercrawl.data.source.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zx_ventures.com.beercrawl.R;
import zx_ventures.com.beercrawl.util.BeerCrawlApplication;

/**
 * Created by ivo on 24/08/17.
 */

public class RetrofitClient {
    public static final String BASE_URL_MAPS = BeerCrawlApplication.getAppContext().getResources().getString(R.string.google_maps_url);
    private static Retrofit retrofitMaps = null;

    public static Retrofit getClientMaps() {
        if (retrofitMaps==null) {
            retrofitMaps = new Retrofit.Builder()
                    .baseUrl(BASE_URL_MAPS)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitMaps;
    }
}
