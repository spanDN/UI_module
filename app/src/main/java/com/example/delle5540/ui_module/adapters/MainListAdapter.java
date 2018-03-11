package com.example.delle5540.ui_module.adapters;

/**
 * Created by dell e5540 on 3/11/2018.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.delle5540.ui_module.R;
import com.example.delle5540.ui_module.model.Topic;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {

    private Topic[] topics;

    public MainListAdapter(Topic[] topics) {
        this.topics = topics;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MainListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LinearLayout lv = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_elem_holder, parent, false);

        ViewHolder vh = new ViewHolder(lv);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView tvTopic = holder.mLv.findViewById(R.id.tvListTopic);
        tvTopic.setText(topics[position].getName());
        TextView tvListDesc = holder.mLv.findViewById(R.id.tvListDesc);
        tvListDesc.setText(topics[position].getDescription());
    }

    @Override
    public int getItemCount() {
        return topics.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout mLv;

        public ViewHolder(LinearLayout lv) {
            super(lv);
            mLv = lv;
        };
    }

}
