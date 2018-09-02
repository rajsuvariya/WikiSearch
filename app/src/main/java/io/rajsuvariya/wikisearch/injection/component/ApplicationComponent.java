
package io.rajsuvariya.wikisearch.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import io.rajsuvariya.wikisearch.WikiSearchApp;
import io.rajsuvariya.wikisearch.data.DataManager;
import io.rajsuvariya.wikisearch.injection.ApplicationContext;
import io.rajsuvariya.wikisearch.injection.module.ApplicationModule;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(WikiSearchApp app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}