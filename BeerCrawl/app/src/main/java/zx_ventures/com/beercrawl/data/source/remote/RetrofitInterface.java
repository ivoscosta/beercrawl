package zx_ventures.com.beercrawl.data.source.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zx_ventures.com.beercrawl.data.Poc;

/**
 * Created by ivo.costa on 23/08/2016.
 */

public interface RetrofitInterface {
    @GET("maps/api/geocode/json")
    Call<Poc> getPocs(@Query("address") String address);

//    @GET("/")
//    Call<Movie> getMovieById(@Query("i") String id, @Query("plot") String plot, @Query("r") String r);
}