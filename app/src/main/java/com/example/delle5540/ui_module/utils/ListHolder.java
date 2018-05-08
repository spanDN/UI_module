package com.example.delle5540.ui_module.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.delle5540.ui_module.model.User;

/**
 * Created by dell e5540 on 4/21/2018.
 */

public class ListHolder extends RecyclerView.ViewHolder {
    private Context context;
    private IItemListener listeneer;
    User user;
    private View itemView;
    public ListHolder(View itemView, Context context, IItemListener<User> listener) {
        super(itemView);
        this.context = context;
        this.listeneer = listener;
        this.itemView = itemView;
    }
}
