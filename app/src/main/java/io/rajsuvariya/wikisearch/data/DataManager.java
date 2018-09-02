
package io.rajsuvariya.wikisearch.data;

import android.content.Context;

import io.rajsuvariya.wikisearch.data.local.PreferencesHelper;
import io.rajsuvariya.wikisearch.data.local.WikiPageDatabase;
import io.rajsuvariya.wikisearch.data.remote.AppApiHelper;
import io.rajsuvariya.wikisearch.data.remote.model.detailsApi.WikiDetailsOutputModel;
import io.rajsuvariya.wikisearch.data.remote.model.searchApi.WikiSearchOutputModel;
import io.rajsuvariya.wikisearch.injection.ApplicationContext;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

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
    private final WikiPageDatabase mWikiPageDatabase;
    private final Context mContext;

    @Inject
    public DataManager(PreferencesHelper preferencesHelper,
                       AppApiHelper apiHelper, @ApplicationContext Context context) {
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mWikiPageDatabase = WikiPageDatabase.getInstance(context);
        mContext = context;
    }

    public Observable<WikiSearchOutputModel> callWikiApi(String queryParam) {
        return mApiHelper.callWikiApi(queryParam);
    }

    public Flowable<WikiDetailsOutputModel> fetchDetailsByTitle(final String title) {
        return Maybe
                .mergeDelayError(mWikiPageDatabase.wikiPageDao().loadByTitle(title),
                        mApiHelper.fetchDetailsByTitle(title).doOnSuccess(new Consumer<WikiDetailsOutputModel>() {
                            @Override
                            public void accept(WikiDetailsOutputModel wikiDetailsOutputModel) throws Exception {
                                saveWikiPage(wikiDetailsOutputModel);
                            }
                        }))
                .take(1);
    }

    public void saveWikiPage(final WikiDetailsOutputModel outputModel) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mWikiPageDatabase.wikiPageDao().insert(outputModel);
            }
        }).start();
    }
}
