
package io.iamBedant.starter.data.remote;

import io.iamBedant.starter.BuildConfig;

/**
 * Created by @iamBedant on 15/03/17.
 */

public final class ApiEndPoint {

    public static final String ENDPOINT_GOOGLE_LOGIN = BuildConfig.BASE_URL
            + "/588d14f4100000a9072d2943";
    public static final String ENDPOINT_FACEBOOK_LOGIN = BuildConfig.BASE_URL
            + "/588d15d3100000ae072d2944";
    public static final String ENDPOINT_SERVER_LOGIN = "http://demo7502315.mockable.io/perf";

    public static final String GAME_OBJECT_ENDPOINT = "http://demo7502315.mockable.io/logos";


    public static final String ENDPOINT_LOGOUT = BuildConfig.BASE_URL
            + "/588d161c100000a9072d2946";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
