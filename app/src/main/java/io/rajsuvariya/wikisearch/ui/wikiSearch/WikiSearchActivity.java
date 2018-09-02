package io.rajsuvariya.wikisearch.ui.wikiSearch;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.rajsuvariya.wikisearch.R;
import io.rajsuvariya.wikisearch.data.remote.model.searchApi.Page;
import io.rajsuvariya.wikisearch.ui.base.BaseActivity;
import io.rajsuvariya.wikisearch.ui.wikiDetails.WikiDetailsActivity;
import io.rajsuvariya.wikisearch.utils.AppConstants;
import io.rajsuvariya.wikisearch.utils.CommonUtils;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

public class WikiSearchActivity extends BaseActivity implements WikiSearchMvpView, SearchResultAdapter.ClickListener {

    @Inject
    WikiSearchMvpPresenter<WikiSearchMvpView> mPresenter;

    @BindView(R.id.tv_search_label)
    TextView tvSearchLabel;

    @BindView(R.id.rv_search_result)
    RecyclerView rvSearchResult;

    @BindView(R.id.pb_loading_indicator)
    ProgressBar pbLoadingIndicator;

    private SearchResultAdapter searchResultAdapter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, WikiSearchActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_search);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(WikiSearchActivity.this);

        setUpSearchLabel();

        searchResultAdapter = new SearchResultAdapter(this);
        rvSearchResult.setAdapter(searchResultAdapter);
        rvSearchResult.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void setUpSearchLabel() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                rvSearchResult.setVisibility(View.GONE);
                tvSearchLabel.setVisibility(View.VISIBLE);
                pbLoadingIndicator.setVisibility(View.GONE);
                String searchLabel = getString(R.string.search_label_hint);
                SpannableString ss = new SpannableString(searchLabel);
                Drawable d = ContextCompat.getDrawable(WikiSearchActivity.this, R.drawable.ic_search_black_24dp);
                d.setBounds(0, 0, (int) CommonUtils.convertDpToPixel(20, WikiSearchActivity.this), (int) CommonUtils.convertDpToPixel(20, WikiSearchActivity.this));
                ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BOTTOM);
                ss.setSpan(span, searchLabel.indexOf("search"), searchLabel.indexOf("search")+6, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                tvSearchLabel.setText(ss);
            }
        });
    }

    @Override
    public void openMainActivity() {
        Intent intent = WikiSearchActivity.getStartIntent(WikiSearchActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void showSearchResults(ArrayList<Page> pages) {
        rvSearchResult.setVisibility(View.VISIBLE);
        tvSearchLabel.setVisibility(View.GONE);
        searchResultAdapter.swapData(pages);
    }

    @Override
    public void showNoResultAvailable() {
        rvSearchResult.setVisibility(View.GONE);
        tvSearchLabel.setVisibility(View.VISIBLE);
        tvSearchLabel.setText(R.string.no_result_error);
    }

    @Override
    public void onClick(Page page) {
        Intent intent = new Intent(this, WikiDetailsActivity.class);
        intent.putExtra(AppConstants.PAGE_TITLE, page.getTitle());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_activity, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        SearchView searchView = (SearchView) menu.getItem(0).getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);//set search menu as full width
        searchView.setQueryHint(getString(R.string.search_hint));
        mPresenter.onSearchTextChanged(RxSearchObservable.fromView(searchView), getString(R.string.network_error));
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void showLoading() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                pbLoadingIndicator.setVisibility(View.VISIBLE);
                rvSearchResult.setVisibility(View.GONE);
                tvSearchLabel.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void hideLoading() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                pbLoadingIndicator.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

}
