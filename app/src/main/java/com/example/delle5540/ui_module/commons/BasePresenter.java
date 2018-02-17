package com.example.delle5540.ui_module.commons;

import android.app.Application;

import com.example.delle5540.ui_module.interactors.IBaseInteractor;

/**
 * Created by dell e5540 on 2/6/2018.
 */

public abstract class BasePresenter<V extends IBaseView, I extends IBaseInteractor> {
    protected V view;
    protected I interactor;
    protected Application application;

    protected void init(V view) {
        this.view = view;
    }

    protected void dismiss() {
        this.view = null;
    }
}