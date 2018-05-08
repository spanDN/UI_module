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

public interface IInteractor {
    /* Observble
       Subsribe  Приготовить перзентацию.
       Subscribe()

       just()
       mmapMap()
       map()
       from()
       doOnNext()*/
    Observable<String> doAuth(Context context, String action, String email, String password, String lang, String timeZone, String devId);
}