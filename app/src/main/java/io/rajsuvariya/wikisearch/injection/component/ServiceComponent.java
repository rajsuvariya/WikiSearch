
package io.rajsuvariya.wikisearch.injection.component;

import io.rajsuvariya.wikisearch.injection.PerService;
import io.rajsuvariya.wikisearch.injection.module.ServiceModule;
import dagger.Component;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {


}
