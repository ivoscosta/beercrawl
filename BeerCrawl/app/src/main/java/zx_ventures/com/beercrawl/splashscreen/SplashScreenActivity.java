package zx_ventures.com.beercrawl.splashscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private SplashScreenContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new SplashScreenPresenter(this);
        mPresenter.completeSplash();
    }
}
