package io.rajsuvariya.wikisearch.utils;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

public final class AppConstants {

    public static final String STATUS_CODE_SUCCESS = "success";
    public static final String STATUS_CODE_FAILED = "failed";

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DB_NAME = "mindorks_mvp.db";
    public static final String PREF_NAME = "mindorks_pref";

    public static final long NULL_INDEX = -1L;

    public static final String SEED_DATABASE_OPTIONS = "seed/options.json";
    public static final String SEED_DATABASE_QUESTIONS = "seed/questions.json";

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    public static final String PAGE_TITLE = "_Page_Title";
    public static final String PAGE_ID = "_Page_Id";

    private AppConstants() {
        throw new RuntimeException("Not allowed to initialize");
        // This utility class is not publicly instantiable
    }
}
