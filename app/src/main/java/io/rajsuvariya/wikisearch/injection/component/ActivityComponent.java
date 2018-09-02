
package io.rajsuvariya.wikisearch.injection.component;

import io.rajsuvariya.wikisearch.injection.PerActivity;
import io.rajsuvariya.wikisearch.injection.module.ActivityModule;
import io.rajsuvariya.wikisearch.ui.splash.SplashActivity;
import io.rajsuvariya.wikisearch.ui.wikiDetails.WikiDetailsActivity;
import io.rajsuvariya.wikisearch.ui.wikiSearch.WikiSearchActivity;
import dagger.Component;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity splashActivity);
    void inject(WikiSearchActivity loginActivity);
    void inject(WikiDetailsActivity wikiDetailsActivity);
}
