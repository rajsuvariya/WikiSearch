
package io.rajsuvariya.wikisearch.data;

import io.rajsuvariya.wikisearch.data.local.PreferencesHelper;
import io.rajsuvariya.wikisearch.data.remote.AppApiHelper;
import io.rajsuvariya.wikisearch.data.remote.model.searchApi.WikiSearchOutputModel;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@Singleton
public class DataManager {

    private static final String TAG = "DataManager";

    private final PreferencesHelper mPreferencesHelper;
    private final AppApiHelper mApiHelper;

    @Inject
    public DataManager( PreferencesHelper preferencesHelper,
                       AppApiHelper apiHelper) {
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }


    public Observable<WikiSearchOutputModel> callWikiApi(String queryParam) {
        return mApiHelper.callWikiApi(queryParam);
    }
}
