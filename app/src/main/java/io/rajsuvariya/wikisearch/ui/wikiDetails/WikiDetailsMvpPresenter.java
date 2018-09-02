package io.rajsuvariya.wikisearch.ui.wikiDetails;

import io.rajsuvariya.wikisearch.ui.base.MvpPresenter;

/**
 * Created by @raj on 01/09/18.
 */
public interface WikiDetailsMvpPresenter<V extends WikiDetailsMvpView> extends MvpPresenter<V>{
    void fetchDetailsByTitle(String title);
}
