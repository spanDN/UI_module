package com.example.delle5540.ui_module.commons;

/**
 * Created by dell e5540 on 1/27/2018.
 */

public interface IBaseView {
    void showMessage(String s);
    void showError(String s);
    void showProgressBar();
    void hideProgressBar();

    interface IAuthView extends IBaseView {
        void openMain(boolean auth);
    }
}
