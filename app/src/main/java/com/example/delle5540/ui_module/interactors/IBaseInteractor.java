package com.example.delle5540.ui_module.interactors;

import android.content.Context;

import rx.Observable;

/**
 * Created by dell e5540 on 2/15/2018.
 */

public interface IBaseInteractor {
    interface IInteractor extends IBaseInteractor {
        Observable<String> doAuth(Context context, String action, String email, String password, String language, String timeZone, String deviceId);
    }
}
