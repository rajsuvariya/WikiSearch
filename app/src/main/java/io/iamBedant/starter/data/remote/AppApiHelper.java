
package io.iamBedant.starter.data.remote;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by @iamBedant on 15/03/17.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }


}

