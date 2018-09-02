package io.rajsuvariya.wikisearch.ui.wikiDetails;

import android.media.Image;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.rajsuvariya.wikisearch.R;
import io.rajsuvariya.wikisearch.data.remote.model.detailsApi.WikiDetailsOutputModel;
import io.rajsuvariya.wikisearch.ui.base.BaseActivity;
import io.rajsuvariya.wikisearch.utils.AppConstants;
import io.rajsuvariya.wikisearch.utils.ViewUtils;

public class WikiDetailsActivity extends BaseActivity implements WikiDetailsMvpView {

    @Inject
    WikiDetailsMvpPresenter<WikiDetailsMvpView> mPresenter;

    @BindView(R.id.tv_summary)
    TextView tvSummary;

    @BindView(R.id.pb_loading_indicator)
    ProgressBar pbLoadingIndicator;

    @BindView(R.id.tv_link)
    TextView tvLink;

    @BindView(R.id.iv_thumbnail)
    ImageView ivThumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_details);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String title = getIntent().getStringExtra(AppConstants.PAGE_TITLE);
        mPresenter.fetchDetailsByTitle(title);
    }

    @Override
    public void showDetailsOnUI(final WikiDetailsOutputModel outputModel) {
        pbLoadingIndicator.setVisibility(View.GONE);
        tvSummary.setVisibility(View.VISIBLE);
        tvLink.setVisibility(View.VISIBLE);
        ivThumbnail.setVisibility(View.VISIBLE);

        getSupportActionBar().setTitle(outputModel.getTitle());

        tvSummary.setText(outputModel.getExtract());
        Glide.with(this).load(outputModel.getThumbnail().getSource()).into(ivThumbnail);
        String linkText = getString(R.string.link_label);
        SpannableString linkSannable = new SpannableString(linkText);
        linkSannable.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                ViewUtils.creatorCustomTabs(WikiDetailsActivity.this, outputModel.getContentUrls().getMobile().getPage());
            }
        }, linkText.indexOf(getString(R.string.link_clickable_part)),
                linkText.indexOf(getString(R.string.link_clickable_part)) + getString(R.string.link_clickable_part).length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvLink.setText(linkSannable);
        tvLink.setMovementMethod(new LinkMovementMethod());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
