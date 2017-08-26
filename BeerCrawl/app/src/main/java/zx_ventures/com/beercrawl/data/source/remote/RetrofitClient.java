package zx_ventures.com.beercrawl.data.source.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zx_ventures.com.beercrawl.R;
import zx_ventures.com.beercrawl.util.PubCrawlApplication;

/**
 * Created by ivo on 24/08/17.
 */

public class RetrofitClient {
    public static final String BASE_URL = PubCrawlApplication.getAppContext().getResources().getString(R.string.api_url);
    private static Retrofit retrofit = null;

    public static final String BASE_URL_MAPS = PubCrawlApplication.getAppContext().getResources().getString(R.string.google_maps_url);
    private static Retrofit retrofitMaps = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

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
