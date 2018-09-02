package io.rajsuvariya.wikisearch.data.remote;

import io.rajsuvariya.wikisearch.data.remote.model.detailsApi.WikiDetailsOutputModel;
import io.rajsuvariya.wikisearch.data.remote.model.searchApi.WikiSearchOutputModel;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by @raj on 31/08/18.
 */
public interface ApiEndpoints {

    @GET("?action=query&format=json&prop=pageimages%7Cpageterms&generator=prefixsearch&redirects=1&formatversion=2&piprop=thumbnail&pithumbsize=50&pilimit=10&wbptterms=description&gpslimit=10")
    Observable<WikiSearchOutputModel> wikiSearch(@Query("gpssearch") String queryParam);

    @GET("/api/rest_v1/page/summary/{title}")
    Maybe<WikiDetailsOutputModel> fetchDetailsByTitle(@Path("title") String title);

}