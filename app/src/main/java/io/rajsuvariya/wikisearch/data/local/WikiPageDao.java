package io.rajsuvariya.wikisearch.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.rajsuvariya.wikisearch.data.remote.model.detailsApi.WikiDetailsOutputModel;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by @raj on 02/09/18.
 */
@Dao
public interface WikiPageDao {
    @Query("SELECT * FROM WikiDetailsOutputModel")
    List<WikiDetailsOutputModel> getAll();

    @Query("SELECT * FROM WikiDetailsOutputModel WHERE title IS :title")
    Maybe<WikiDetailsOutputModel> loadByTitle(String title);

    @Insert
    void insert(WikiDetailsOutputModel wikiDetailsOutputModel);

    @Delete
    void delete(WikiDetailsOutputModel wikiDetailsOutputModel);
}
