package io.rajsuvariya.wikisearch;

import android.app.Application;
import io.rajsuvariya.wikisearch.data.DataManager;
import io.rajsuvariya.wikisearch.injection.component.ApplicationComponent;
import io.rajsuvariya.wikisearch.injection.component.DaggerApplicationComponent;
import io.rajsuvariya.wikisearch.injection.module.ApplicationModule;
import javax.inject.Inject;
import timber.log.Timber;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

public class IfaApp extends Application {
  @Inject DataManager mDataManager;


  private ApplicationComponent mApplicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    mApplicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this)).build();

    mApplicationComponent.inject(this);

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }

  }

  public ApplicationComponent getComponent() {
    return mApplicationComponent;
  }


  // Needed to replace the component with a test specific one
  public void setComponent(ApplicationComponent applicationComponent) {
    mApplicationComponent = applicationComponent;
  }
}
