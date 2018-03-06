package com.example.delle5540.ui_module.commons;

import android.content.Intent;
import android.util.Log;

import com.example.delle5540.ui_module.R;
import com.example.delle5540.ui_module.auth_operation.activities.AuthActivity;
import com.example.delle5540.ui_module.interactors.IAuthInteractor;
import com.example.delle5540.ui_module.interactors.IBaseInteractor;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;

import java.util.Arrays;

/**
 * Created by dell e5540 on 3/6/2018.
 */

public class MainPresenterImpl extends BasePresenter<IBaseView.IMainView, IBaseInteractor.IAuthInteractor> implements IMainPresenter {

    private CallbackManager callbackManager;

    @Override
    public void doLogout(String token, int type) {

            callbackManager = CallbackManager.Factory.create();
            Log.d("SOCIAL", "AfterCallBackManager");
            if (AccessToken.getCurrentAccessToken() == null) {
                Log.d("SOCIAL", "NUll");
                return;
            } else {
                Log.d("SOCIAL", "Has token, go logout " + AccessToken.getCurrentAccessToken().getToken());
                LoginManager.getInstance().logOut();
                if (AccessToken.getCurrentAccessToken() == null) {
                    Log.d("SOCIAL", "Logged out ");
                    /* How I can find activity here */
                    /* onBackPressed() */
                    view.closeMain();

                }
            }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void init(IBaseView.IMainView view) {
        super.init(view);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

}
