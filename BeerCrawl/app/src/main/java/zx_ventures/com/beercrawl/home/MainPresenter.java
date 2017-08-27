package zx_ventures.com.beercrawl.home;

import android.support.annotation.NonNull;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zx_ventures.com.beercrawl.data.source.remote.RetrofitClient;
import zx_ventures.com.beercrawl.data.source.remote.RetrofitInterface;
import zx_ventures.com.beercrawl.data.source.remote.dto.geocode.ResultDto;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by ivo on 24/08/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View mLocationsView;
    private RetrofitInterface apiService;

    public MainPresenter(@NonNull MainActivity activity) {
        mLocationsView = checkNotNull(activity);
        apiService = RetrofitClient.getClientMaps().create(RetrofitInterface.class);

        mLocationsView.setPresenter(this);
    }

    @Override
    public void searchLocation(String query) {
        mLocationsView.showProgress();
        Call<ResultDto> call = apiService.getLocations(query);
        call.enqueue(new Callback<ResultDto>() {
            @Override
            public void onResponse(Call<ResultDto>call, Response<ResultDto> response) {
                if(response.errorBody() == null) {
                    if (response.body() != null) {
                        mLocationsView.hideProgress();
                        mLocationsView.showLocations(response.body().getResults());
                    }
                }
                else
                    Log.e("###", response.errorBody().toString());
            }

            @Override
            public void onFailure(Call<ResultDto>call, Throwable t) {
                // Log error here since request failed
                Log.e("###", t.toString());
            }
        });
    }

    @Override
    public void start() {

    }
}