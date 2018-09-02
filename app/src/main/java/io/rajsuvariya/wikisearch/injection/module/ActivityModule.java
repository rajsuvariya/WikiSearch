package io.rajsuvariya.wikisearch.injection.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import io.rajsuvariya.wikisearch.injection.ActivityContext;
import io.rajsuvariya.wikisearch.injection.PerActivity;
import io.rajsuvariya.wikisearch.ui.splash.SplashMvpPresenter;
import io.rajsuvariya.wikisearch.ui.splash.SplashMvpView;
import io.rajsuvariya.wikisearch.ui.splash.SplashPresenter;
import io.rajsuvariya.wikisearch.ui.wikiDetails.WikiDetailsMvpPresenter;
import io.rajsuvariya.wikisearch.ui.wikiDetails.WikiDetailsMvpView;
import io.rajsuvariya.wikisearch.ui.wikiDetails.WikiDetailsPresenter;
import io.rajsuvariya.wikisearch.ui.wikiSearch.WikiSearchMvpPresenter;
import io.rajsuvariya.wikisearch.ui.wikiSearch.WikiSearchMvpView;
import io.rajsuvariya.wikisearch.ui.wikiSearch.WikiSearchPresenter;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    WikiSearchMvpPresenter<WikiSearchMvpView> provideWikiSearchPresenter(WikiSearchPresenter<WikiSearchMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    WikiDetailsMvpPresenter<WikiDetailsMvpView> provideWikiDetailsPresenter(WikiDetailsPresenter<WikiDetailsMvpView> presenter) {
        return presenter;
    }
}
