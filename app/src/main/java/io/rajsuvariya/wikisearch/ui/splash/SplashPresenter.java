package io.rajsuvariya.wikisearch.ui.splash;
import javax.inject.Inject;

import io.rajsuvariya.wikisearch.data.DataManager;
import io.rajsuvariya.wikisearch.ui.base.BasePresenter;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V>
        implements SplashMvpPresenter<V> {

    @Inject
    public SplashPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }


}
