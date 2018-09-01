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
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.rajsuvariya.wikisearch.R;
import io.rajsuvariya.wikisearch.data.remote.model.searchApi.Page;
import io.rajsuvariya.wikisearch.ui.base.BaseActivity;
import io.rajsuvariya.wikisearch.utils.CommonUtils;

/**
 * Created by @rajsuvariya on 15/03/17.
 */

public class WikiSearchActivity extends BaseActivity implements WikiSearchMvpView {

    @Inject
    WikiSearchMvpPresenter<WikiSearchMvpView> mPresenter;

    @BindView(R.id.tv_search_label)
    TextView tvSearchLabel;

    @BindView(R.id.rv_search_result)
    RecyclerView rvSearchResult;

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

        setUpSearchLabelTv();

        searchResultAdapter = new SearchResultAdapter();
        rvSearchResult.setAdapter(searchResultAdapter);
        rvSearchResult.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpSearchLabelTv() {
        String searchLabel = "Please press search icon to get started";
        SpannableString ss = new SpannableString(searchLabel);
        Drawable d = ContextCompat.getDrawable(this, R.drawable.ic_search_black_24dp);
        d.setBounds(0, 0, (int) CommonUtils.convertDpToPixel(20, this), (int) CommonUtils.convertDpToPixel(20, this));
        ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BOTTOM);
        ss.setSpan(span, searchLabel.indexOf("search"), searchLabel.indexOf("search")+6, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        tvSearchLabel.setText(ss);
    }

    @Override
    public void openMainActivity() {
        Intent intent = WikiSearchActivity.getStartIntent(WikiSearchActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void showSearchResults(ArrayList<Page> pages) {
        searchResultAdapter.swapData(pages);
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
        mPresenter.onSearchTextChanged(RxSearchObservable.fromView(searchView));
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }
}
