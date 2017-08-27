package zx_ventures.com.beercrawl.data.source.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zx_ventures.com.beercrawl.data.source.remote.dto.geocode.ResultDto;

/**
 * Created by ivo.costa on 23/08/2016.
 */

public interface RetrofitInterface {
    @GET("maps/api/geocode/json")
    Call<ResultDto> getLocations(@Query("address") String address);
}