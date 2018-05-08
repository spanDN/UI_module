package com.example.delle5540.ui_module.utils;

/**
 * Created by dell e5540 on 4/21/2018.
 */

public interface IItemListener<M> {
    void remove (M model, int position);
    void open (M model);
    void apply (M model);
}
