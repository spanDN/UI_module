package com.example.delle5540.ui_module.commons;

import android.app.Application;

/**
 * Created by dell e5540 on 2/6/2018.
 */

public abstract class BasePresenter <V extends IBaseView>
{
    protected  V view;
    protected Application application;
//    protected BaseInteractor interactor;

   protected void init(V view) {
        this.view = view;
    }

   protected void dissmiss() {
        this.view = null;
    }
}
