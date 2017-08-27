package zx_ventures.com.beercrawl.data.source.remote;

import okhttp3.OkHttpClient;
import zx_ventures.com.beercrawl.R;
import zx_ventures.com.beercrawl.util.PubCrawlApplication;

/**
 * Created by ivo on 24/08/17.
 */

public class ApolloClient {
    public static final String BASE_URL = PubCrawlApplication.getAppContext().getResources().getString(R.string.graphql_url);
    private static com.apollographql.apollo.ApolloClient apollo = null;
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .build();

    public static com.apollographql.apollo.ApolloClient getClientApollo() {
        if (apollo==null) {
            apollo = com.apollographql.apollo.ApolloClient.builder()
                    .serverUrl(BASE_URL)
                    .okHttpClient(okHttpClient)
                    .build();
        }
        return apollo;
    }
}
