

package io.rajsuvariya.wikisearch.ui.wikiSearch;

import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.rajsuvariya.wikisearch.data.DataManager;
import io.rajsuvariya.wikisearch.data.remote.model.searchApi.Page;
import io.rajsuvariya.wikisearch.data.remote.model.searchApi.WikiSearchOutputModel;
import io.rajsuvariya.wikisearch.ui.base.BasePresenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

public class WikiSearchPresenter<V extends WikiSearchMvpView> extends BasePresenter<V>
        implements WikiSearchMvpPresenter<V> {

    private static final String TAG = "WikiSearchPresenter";

    @Inject
    public WikiSearchPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onSearchTextChanged(Observable<String> queryObservable) {
        getCompositeDisposable().add(queryObservable
                .debounce(500, TimeUnit.MILLISECONDS)
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String text) throws Exception {
                        return !text.isEmpty();
                    }
                })
                .distinctUntilChanged()
                .switchMap(new Function<String, Observable<WikiSearchOutputModel>>() {
                    @Override
                    public Observable<WikiSearchOutputModel> apply(String query) throws Exception {
                        return callWikiApi(query);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WikiSearchOutputModel>() {
                    @Override
                    public void accept(WikiSearchOutputModel outputModel) throws Exception {
                        getMvpView().showSearchResults((ArrayList<Page>) outputModel.getQuery().getPages());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.wtf("WikiSearchPresenter", throwable);
                    }
                })
        );
    }

    private Observable<WikiSearchOutputModel> callWikiApi(String queryParam) {
        return getDataManager().callWikiApi(queryParam);
    }
}
