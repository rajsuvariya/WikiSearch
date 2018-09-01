package io.rajsuvariya.wikisearch.ui.wikiSearch;


import io.rajsuvariya.wikisearch.data.remote.model.searchApi.WikiSearchOutputModel;
import io.rajsuvariya.wikisearch.injection.PerActivity;
import io.rajsuvariya.wikisearch.ui.base.MvpPresenter;
import io.reactivex.Observable;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@PerActivity
public interface WikiSearchMvpPresenter<V extends WikiSearchMvpView> extends MvpPresenter<V> {
    void onSearchTextChanged(Observable<String> queryObservable);
}
