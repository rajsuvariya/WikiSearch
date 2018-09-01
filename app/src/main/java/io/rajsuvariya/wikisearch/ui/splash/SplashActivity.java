package io.rajsuvariya.wikisearch.ui.splash;

import android.os.Bundle;

import javax.inject.Inject;

import io.rajsuvariya.wikisearch.R;
import io.rajsuvariya.wikisearch.ui.base.BaseActivity;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements SplashMvpView{

    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(SplashActivity.this);

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void openLoginActivity() {

    }

    @Override
    public void openMainActivity() {

    }

}
