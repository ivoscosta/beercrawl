package zx_ventures.com.beercrawl.productlist;

import android.support.annotation.NonNull;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Nonnull;

import zx_ventures.com.beercrawl.data.AllCategoriesSearchQuery;
import zx_ventures.com.beercrawl.data.LocationMap;
import zx_ventures.com.beercrawl.data.PocCategorySearchQuery;
import zx_ventures.com.beercrawl.data.PocSearchMethodQuery;

/**
 * Created by ivo on 26/08/17.
 */

public class ProductListPresenter implements ProductListContract.Presenter {

    private final ProductListContract.View mProductListView;
    private ApolloClient mApolloClient;
    private ProductListActivity mActivity;
    private LocationMap mLocationMap;
    private PocSearchMethodQuery.PocSearch mPoc;
    private AllCategoriesSearchQuery.AllCategory mFirstCategory;

    public ProductListPresenter(@NonNull ProductListActivity activity, LocationMap location) {
        mProductListView = activity;
        mApolloClient = zx_ventures.com.beercrawl.data.source.remote.ApolloClient.getClientApollo();
        mActivity = activity;
        mLocationMap = location;
    }

    @Override
    public void getAllCategories() {
        mApolloClient.query(AllCategoriesSearchQuery.builder()
                .build()).enqueue(new ApolloCall.Callback<AllCategoriesSearchQuery.Data>() {

            @Override
            public void onResponse(@Nonnull final Response<AllCategoriesSearchQuery.Data> dataResponse) {
                if (dataResponse.data().allCategory().size() > 0) {
                    mFirstCategory = dataResponse.data().allCategory().get(0);

                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mProductListView.showAllCategories(dataResponse.data().allCategory());
                        }
                    });

                    verifyLoadedData();
                }
            }

            @Override
            public void onFailure(@Nonnull ApolloException t) {
                Log.e("###", t.getMessage(), t);
            }
        });
    }

    @Override
    public void getPoc(LocationMap location) {
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String now = formatter.format(today);

        mApolloClient.query(PocSearchMethodQuery.builder()
                .algorithm("NEAREST")
                .lat(location.getGeometry().getLocation().getLat().toString())
                .lng(location.getGeometry().getLocation().getLng().toString())
                .now(now)
                .build()).enqueue(new ApolloCall.Callback<PocSearchMethodQuery.Data>() {

            @Override
            public void onResponse(@Nonnull final Response<PocSearchMethodQuery.Data> dataResponse) {
                if (dataResponse.data().pocSearch().size() > 0) {
                    mPoc = dataResponse.data().pocSearch().get(0);
                    verifyLoadedData();
                }
            }

            @Override
            public void onFailure(@Nonnull ApolloException t) {
                Log.e("###", t.getMessage(), t);
            }
        });
    }

    void verifyLoadedData() {
        if (mPoc != null && mFirstCategory != null)
            getCategoryProducts(mFirstCategory.id());
    }

    @Override
    public void getCategoryProducts(String idCategory) {
        if(mPoc != null) {
            mApolloClient.query(PocCategorySearchQuery.builder()
                    .id(mPoc.id())
                    .search("")
                    .categoryId(Integer.parseInt(idCategory))
                    .build()).enqueue(new ApolloCall.Callback<PocCategorySearchQuery.Data>() {

                @Override
                public void onResponse(@Nonnull final Response<PocCategorySearchQuery.Data> dataResponse) {
                    // onResponse returns on a background thread.
                    mActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (dataResponse.data().poc().products().size() > 0)
                                mProductListView.showCategoryProducts(dataResponse.data().poc().products());
                        }
                    });
                }

                @Override
                public void onFailure(@Nonnull ApolloException t) {
                    Log.e("###", t.getMessage(), t);
                }
            });
        }
    }

    @Override
    public void start() {
        getPoc(mLocationMap);
        getAllCategories();
    }
}
