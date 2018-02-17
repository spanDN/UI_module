package com.example.delle5540.ui_module.commons;

import android.content.Context;
import android.util.Patterns;

import com.example.delle5540.ui_module.R;
import com.example.delle5540.ui_module.interactors.IAuthInteractor;
import com.example.delle5540.ui_module.interactors.IBaseInteractor;
import com.example.delle5540.ui_module.model.AuthModel;

import rx.Observable;

/**
 * Created by dell e5540 on 2/15/2018.
 */

public class AuthInteractorImpl implements IBaseInteractor.IAuthInteractor {

    private boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    ;

    @Override
    public Observable<String> doAuth(Context context, String action, String email, String password, String lang, String timeZone, String devId) {

        AuthModel model = new AuthModel();
        model.setAction(action);
        model.setEmail(email);
        model.setPassword(password);
        model.setLang(lang);
        model.setDevId(devId);
        return Observable.just(model).flatMap(authModel -> {
            if (isEmailValid(authModel.getEmail())) {
                return Observable.just(authModel.getAction() + "success");
            } else {
                return Observable.just(authModel.getEmail() + "is not valid");
            }
        });
    }
}
