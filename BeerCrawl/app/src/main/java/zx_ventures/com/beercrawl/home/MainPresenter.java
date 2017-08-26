package zx_ventures.com.beercrawl.home;

import android.support.annotation.NonNull;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zx_ventures.com.beercrawl.data.Poc;
import zx_ventures.com.beercrawl.data.source.remote.RetrofitClient;
import zx_ventures.com.beercrawl.data.source.remote.RetrofitInterface;

/**
 * Created by ivo on 24/08/17.
 */

public class MainPresenter implements MainContract.Presenter{

    private final MainContract.View mPocsView;
    private RetrofitInterface apiService;

    public MainPresenter(@NonNull MainActivity activity) {
        mPocsView = activity;
        apiService = RetrofitClient.getClientMaps().create(RetrofitInterface.class);
    }

    @Override
    public void searchPoc(String query) {
        Call<Poc> call = apiService.getPocs(query);
        call.enqueue(new Callback<Poc>() {
            @Override
            public void onResponse(Call<Poc>call, Response<Poc> response) {
                if(response.errorBody() == null) {
                    if (response.body() != null) {
                        mPocsView.showPocs(response.body());
                    }
                }
                else
                    Log.e("###", response.errorBody().toString());
            }

            @Override
            public void onFailure(Call<Poc>call, Throwable t) {
                // Log error here since request failed
                Log.e("###", t.toString());
            }
        });
    }

    @Override
    public void selectPoc() {

    }
}