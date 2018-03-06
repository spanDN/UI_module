package com.example.delle5540.ui_module.commons;

import android.content.Intent;

import com.example.delle5540.ui_module.interactors.IBaseInteractor;
import android.app.Application;
/**
 * Created by dell e5540 on 3/6/2018.
 */

public interface IMainPresenter <V extends IBaseView.IMainView> {
    void doLogout(String token, int type);
    void onActivityResult(int requestCode, int resultCode, Intent data);
    void init(V view);
    void dismiss();
}

