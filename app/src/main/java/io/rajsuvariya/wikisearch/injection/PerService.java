
package io.rajsuvariya.wikisearch.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerService {
}

