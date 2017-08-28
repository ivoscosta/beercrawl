package zx_ventures.com.beercrawl.splashscreen;

import android.content.Intent;
import android.support.annotation.NonNull;

import zx_ventures.com.beercrawl.home.MainActivity;

/**
 * Created by ivo on 23/08/17.
 */

public class SplashScreenPresenter implements SplashScreenContract.Presenter {

    private final SplashScreenActivity mActivity;

    public SplashScreenPresenter(@NonNull SplashScreenActivity activity) {
        mActivity = activity;
    }

    @Override
    public void completeSplash() {
        Intent intent = new Intent(mActivity, MainActivity.class);
        mActivity.startActivity(intent);
        mActivity.finish();
    }
}
