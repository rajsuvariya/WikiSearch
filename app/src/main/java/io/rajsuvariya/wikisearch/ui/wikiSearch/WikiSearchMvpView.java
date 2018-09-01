package io.rajsuvariya.wikisearch.ui.wikiSearch;

import java.util.ArrayList;
import java.util.List;

import io.rajsuvariya.wikisearch.data.remote.model.searchApi.Page;
import io.rajsuvariya.wikisearch.ui.base.MvpView;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

public interface WikiSearchMvpView extends MvpView {

    void openMainActivity();

    void showSearchResults(ArrayList<Page> pages);
}
