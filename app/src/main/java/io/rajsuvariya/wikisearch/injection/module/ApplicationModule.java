
package io.rajsuvariya.wikisearch.injection.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.rajsuvariya.wikisearch.data.remote.ApiHelper;
import io.rajsuvariya.wikisearch.data.remote.AppApiHelper;
import io.rajsuvariya.wikisearch.injection.ApplicationContext;
import io.rajsuvariya.wikisearch.injection.DatabaseInfo;
import io.rajsuvariya.wikisearch.injection.PreferenceInfo;
import io.rajsuvariya.wikisearch.utils.AppConstants;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }


    @Provides
    @Singleton ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }



}
