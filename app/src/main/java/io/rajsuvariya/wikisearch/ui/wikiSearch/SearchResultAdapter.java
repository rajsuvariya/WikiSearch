package io.rajsuvariya.wikisearch.ui.wikiSearch;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.rajsuvariya.wikisearch.R;
import io.rajsuvariya.wikisearch.data.remote.model.searchApi.Page;

/**
 * Created by @raj on 01/09/18.
 */
public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.SearchResultViewHolder> {

    private ArrayList<Page> mPageList;
    private ClickListener mListener;

    public SearchResultAdapter(ClickListener listener) {
        this.mPageList = new ArrayList<>();
        this.mListener = listener;
    }

    @NonNull
    @Override
    public SearchResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_result, parent, false);
        return new SearchResultViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchResultViewHolder holder, final int position) {
        Glide.with(holder.itemView.getContext())
                .load(mPageList.get(position).getImageUrl())
                .placeholder(holder.itemView.getContext().getResources().getDrawable(R.drawable.ic_image_not_available))
                .into(holder.ivResultImage);

        holder.tvResultTitle.setText(mPageList.get(position).getTitle());

        holder.tvResultDescription.setText(mPageList.get(position).getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(mPageList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPageList.size();
    }

    public void swapData(ArrayList<Page> newList) {
        mPageList.clear();
        mPageList.addAll(newList);
        notifyDataSetChanged();
    }

    class SearchResultViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_result_image)
        ImageView ivResultImage;

        @BindView(R.id.tv_result_title)
        TextView tvResultTitle;

        @BindView(R.id.tv_result_description)
        TextView tvResultDescription;

        public SearchResultViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    interface ClickListener {
        void onClick(Page page);
    }
}
