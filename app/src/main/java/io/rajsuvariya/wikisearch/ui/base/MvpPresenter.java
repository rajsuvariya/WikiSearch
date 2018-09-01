
package io.rajsuvariya.wikisearch.ui.base;

/**
 * Created by @rajsuvariya on 15/03/17.
 */


/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError();

    void setUserAsLoggedOut();
}
