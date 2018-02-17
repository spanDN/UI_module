package com.example.delle5540.ui_module.commons;

import android.content.Context;

/**
 * Created by dell e5540 on 1/27/2018.
 */

public interface IBasePresenter {
    void dismiss();
    interface IAuthPresenter <V extends IBaseView.IAuthView> extends IBasePresenter{
        void loginSocial(int type, Context context);
        void signIn( String email, String password, String lang, String timeZone, String devID, Context context);
        void signUp(String email, String password, String repeatPassword, String lang, String timeZone, String devID, Context context);
        void resetAccount(String email, Context context);
        void init(V v);
//        void sendtoPresenterCallBack(ICallback ic);
    }
//    interface IMainPresenter <V extends IBaseView.IMainView> extends IBasePresenter {
//        boolean doIsAuth();
//        void getList();
//        void doLogout();
//        void init(V v);
//    }
}
