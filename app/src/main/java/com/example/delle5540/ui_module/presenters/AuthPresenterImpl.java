package com.example.delle5540.ui_module.presenters;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.delle5540.ui_module.R;
import com.example.delle5540.ui_module.activities.AuthActivity;
import com.example.delle5540.ui_module.commons.BasePresenter;
import com.example.delle5540.ui_module.commons.IBasePresenter;
import com.example.delle5540.ui_module.commons.IBaseView;
import com.example.delle5540.ui_module.interactors.IBaseInteractor;
import com.example.delle5540.ui_module.commons.SocialType;



import rx.Observable;
import rx.Subscriber;

import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.login.*;
import com.facebook.FacebookCallback;
import com.facebook.CallbackManager;

import java.util.Arrays;



/**
 * Created by dell e5540 on 2/6/2018.
 */

public class AuthPresenterImpl extends BasePresenter<IBaseView.IAuthView, IBaseInteractor.IAuthInteractor> implements IBasePresenter.IAuthPresenter<IBaseView.IAuthView> {


    public AuthPresenterImpl(Application application, IBaseInteractor.IAuthInteractor interactor) {
        this.application = application;
        this.interactor = interactor;
    }

    private CallbackManager callbackManager;

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void signIn(String email, String password, String lang, String timeZone, String devID, Context context) {
        String action = context.getResources().getString(R.string.action_sign_in);
        Observable<String> signInObservable = interactor.doAuth(context, action, email, password, lang, timeZone, devID);

// Lambda
//        signInObservable
//                .subscribe(response -> {
//                            view.showMessage(response);
//                        }, throwable -> {
//                            view.showMessage(throwable.getMessage());
//                        },
//                        () -> {
//
//                        });

// Classic way
        signInObservable.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d("OnComplete", "");
            }

            @Override
            public void onError(Throwable e) {
                view.showMessage(e.getMessage());
            }

            @Override
            public void onNext(String s) {
                Log.d("OnNext ", s);
                view.showMessage(s);
            }
        });

    }

    @Override
    public void signUp(String email, String password, String repeatPassword, String lang, String timeZone, String devID, Context context) {

    }

    @Override
    public void resetAccount(String email, Context context) {

    }

    @Override
    public void init(IBaseView.IAuthView view) {
        super.init(view);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

    }

    @Override
    public void loginWithFB(AuthActivity a) {

        callbackManager = CallbackManager.Factory.create();
        if (AccessToken.getCurrentAccessToken() == null) {
            LoginManager.getInstance().registerCallback(callbackManager, facebookCallback);
            LoginManager.getInstance().logInWithReadPermissions(a, Arrays.asList(application.getString(R.string.facebook_scope_profile), application.getString(R.string.facebook_scope_user_friends)));
            return;
        }
        final String token = AccessToken.getCurrentAccessToken().getToken();
        this.socialLogin(SocialType.FACEBOOK, token, null);

    }

    @Override
    public void loginWithGoogle(AuthActivity a) {

    }

    @Override
    public void loginWithTwiter(AuthActivity a) {

    }

    private FacebookCallback<LoginResult> facebookCallback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            if (view == null) return;
            final String token = AccessToken.getCurrentAccessToken().getToken();
            Log.d("SOCIAL", "Facebook token " + token);
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onError(FacebookException error) {
            error.printStackTrace();
            if (view == null) return;
            view.showError(application.getString(R.string.error_text_facebook_error));
        }
    };
}
