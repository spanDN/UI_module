package com.example.delle5540.ui_module.interactors;

import android.content.Context;

import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.MultipartBody;
import rx.Observable;
import rx.Observer;

/**
 * Created by dell e5540 on 2/15/2018.
 */

public interface IBaseInteractor {
    interface IInteractor extends IBaseInteractor {
        Observable<String> doAuth(Context context, String action, String email, String password, String language, String timeZone, String deviceId);
        Observable<JsonObject> uploadFiles(String action, String authKeyOrEmail, List<MultipartBody.Part> part);
        Observable<JsonObject> uploadFile(String action, String authKeyOrEmail, MultipartBody.Part part);
        Observable<JsonObject> signIn(String email, String password);
    }
}
