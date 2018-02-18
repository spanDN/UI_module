package com.example.delle5540.ui_module.presenters;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.delle5540.ui_module.R;
import com.example.delle5540.ui_module.commons.BasePresenter;
import com.example.delle5540.ui_module.commons.IBasePresenter;
import com.example.delle5540.ui_module.commons.IBaseView;
import com.example.delle5540.ui_module.interactors.IBaseInteractor;


import rx.Observable;
import rx.Subscriber;


/**
 * Created by dell e5540 on 2/6/2018.
 */

public class AuthPresenterImpl extends BasePresenter<IBaseView.IAuthView, IBaseInteractor.IAuthInteractor> implements IBasePresenter.IAuthPresenter<IBaseView.IAuthView> {


    public AuthPresenterImpl(Application application, IBaseInteractor.IAuthInteractor interactor) {
        this.application = application;
        this.interactor = interactor;
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void loginSocial(int type, Context context) {
        view.showMessage ("LoginSocial");
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
                Log.d("OnComplete", "" );
            }

            @Override
            public void onError(Throwable e) {
                view.showMessage(e.getMessage());
            }

            @Override
            public void onNext(String s) {
                Log.d("OnNext ", s );
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
}
