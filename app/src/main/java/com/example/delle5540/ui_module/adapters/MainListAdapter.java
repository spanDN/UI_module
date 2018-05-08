package com.example.delle5540.ui_module.adapters;

/**
 * Created by dell e5540 on 3/11/2018.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.delle5540.ui_module.R;
import com.example.delle5540.ui_module.model.Topic;
import com.example.delle5540.ui_module.model.User;
import com.example.delle5540.ui_module.utils.IItemListener;
import com.example.delle5540.ui_module.utils.ListHolder;

import java.util.ArrayList;
import java.util.List;



public class MainListAdapter extends RecyclerView.Adapter<ListHolder> {

    private List<User> mList = new ArrayList<User>();
    private Context context;
    private IItemListener<User> listener;

    public MainListAdapter(Context context, IItemListener<User> listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.support_simple_spinner_dropdown_item, parent, false);
        return new ListHolder(itemView, context, listener);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
//        holder.bindData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addItems(List<User> items) {
        if (items.size() < 0) {
            return;
        } else mList.addAll(items);
        this.notifyDataSetChanged();
    }

    public void renameItems() {
        mList.clear();
        this.notifyDataSetChanged();
    }

    public void replace(User user, int position) {
        mList.set(position, user);
        this.notifyItemChanged(position);
    }

    public void addItem(User user, int position) {
        if (position < 0) {
            mList.add(user);
        } else {
            mList.add(position, user);
        }
        this.notifyDataSetChanged();

    }
}

//public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {
//
//    private Topic[] topics;
//    private List<User> mList = new ArrayList<>();
//
//    public MainListAdapter(Topic[] topics) {
//        this.topics = topics;
//    }
//    // Create new views (invoked by the layout manager)
//    @Override
//    public MainListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
//                                                         int viewType) {
//    View ItemView = LayoutInflater.from(parent.getContext())
//            .inflate(R.layout.list_elem_holder, parent, false);
//
//        ViewHolder vh = new ViewHolder((LinearLayout) ItemView);
//        return vh;
//    }
//
//
///*
//
//    // Create new views (invoked by the layout manager)
//    @Override
//    public MainListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
//                                                   int viewType) {
//        // create a new view
//        LinearLayout lv = (LinearLayout) LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.list_elem_holder, parent, false);
//
//        ViewHolder vh = new ViewHolder(lv);
//        return vh;
//    }
//*/
//    // Replace the contents of a view (invoked by the layout manager)
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        // - get element from your dataset at this position
//        // - replace the contents of the view with that element
//        TextView tvTopic = holder.mLv.findViewById(R.id.tvListTopic);
//        tvTopic.setText(topics[position].getName());
//        TextView tvListDesc = holder.mLv.findViewById(R.id.tvListDesc);
//        tvListDesc.setText(topics[position].getDescription());
//    }
//
//    @Override
//    public int getItemCount() {
//        return topics.length;
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//
//        public LinearLayout mLv;
//
//        public ViewHolder(LinearLayout lv) {
//            super(lv);
//            mLv = lv;
//        };
//    }
//
//    public void addItems(List<User> items) {
//        if(items.size()< 0) {
//            return;
//        }
//        mList.addAll(items);
//        this.notifyDataSetChanged();
//    }
//
//    void removeItems(){
//        mList.clear();
//        this.notifyDataSetChanged();
//    }
//
//    void replaceUser( User user, int position) {
//        mList.set(position, user);
//        this.notifyItemInserted(position);
//    }
//
//    void addItem(User user, int position) {
//        if ( position < 0 ) {
//            mList.add(user);
//        }  else {
//            mList.add(position, user);
//        }
//        this.notifyDataSetChanged();
//    }
//}