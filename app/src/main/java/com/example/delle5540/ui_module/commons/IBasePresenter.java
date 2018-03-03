package com.example.delle5540.ui_module.commons;

import android.content.Context;
import android.content.Intent;

import com.example.delle5540.ui_module.activities.AuthActivity;

/**
 * Created by dell e5540 on 1/27/2018.
 */

public interface IBasePresenter {
    void dismiss();
    interface IAuthPresenter <V extends IBaseView.IAuthView> extends IBasePresenter{
        void signIn( String email, String password, String lang, String timeZone, String devID, Context context);
        void signUp(String email, String password, String repeatPassword, String lang, String timeZone, String devID, Context context);
        void resetAccount(String email, Context context);
        void init(V v);

        void onActivityResult(int requestCode, int resultCode, Intent intent);
        void loginWithFB(AuthActivity a);
        void loginWithGoogle(AuthActivity a);
        void loginWithTwiter(AuthActivity a);

//      void sendtoPresenterCallBack(ICallback ic);
    }
//    interface IMainPresenter <V extends IBaseView.IMainView> extends IBasePresenter {
//        boolean doIsAuth();
//        void getList();
//        void doLogout();
//        void init(V v);
//    }
}