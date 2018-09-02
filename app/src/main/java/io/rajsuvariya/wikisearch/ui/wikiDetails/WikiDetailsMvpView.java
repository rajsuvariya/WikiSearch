package io.rajsuvariya.wikisearch.ui.wikiDetails;

import io.rajsuvariya.wikisearch.data.remote.model.detailsApi.WikiDetailsOutputModel;
import io.rajsuvariya.wikisearch.ui.base.MvpView;

/**
 * Created by @raj on 01/09/18.
 */
public interface WikiDetailsMvpView extends MvpView {
    void showDetailsOnUI(WikiDetailsOutputModel outputModel);
}
