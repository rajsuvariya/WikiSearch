package io.rajsuvariya.wikisearch.ui.wikiDetails;

import javax.inject.Inject;

import io.rajsuvariya.wikisearch.data.DataManager;
import io.rajsuvariya.wikisearch.data.remote.model.detailsApi.WikiDetailsOutputModel;
import io.rajsuvariya.wikisearch.ui.base.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by @raj on 01/09/18.
 */
public class WikiDetailsPresenter<V extends WikiDetailsMvpView> extends BasePresenter<V>
        implements WikiDetailsMvpPresenter<V>  {

    @Inject
    public WikiDetailsPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void fetchDetailsByTitle(final String title) {
        getCompositeDisposable().add(
                getDataManager().fetchDetailsByTitle(title)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WikiDetailsOutputModel>() {
                    @Override
                    public void accept(WikiDetailsOutputModel outputModel) throws Exception {
                        getMvpView().showDetailsOnUI(outputModel);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().showToast(throwable.getMessage());
                    }
                })
        );
    }
}
