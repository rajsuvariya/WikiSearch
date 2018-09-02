package io.rajsuvariya.wikisearch.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import io.rajsuvariya.wikisearch.data.remote.model.detailsApi.WikiDetailsOutputModel;

/**
 * Created by @raj on 02/09/18.
 */
@Database(entities = {WikiDetailsOutputModel.class}, version = 1, exportSchema = false)
public abstract class WikiPageDatabase extends RoomDatabase {
    private static WikiPageDatabase sInstance;
    private static final Object LOCK = new Object();
    private static final String DB_NAME = "wiki_pages";

    public static WikiPageDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context,
                            WikiPageDatabase.class, DB_NAME)
                            .build();
                }
            }
        }
        return sInstance;
    }

    public abstract WikiPageDao wikiPageDao();
}
