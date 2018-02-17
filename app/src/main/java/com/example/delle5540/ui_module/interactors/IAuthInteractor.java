package com.example.delle5540.ui_module.interactors;

import android.content.Context;

import rx.Observable;

/**
 * Created by dell e5540 on 2/15/2018.
 */

public interface IAuthInteractor {
    /* Observble
       Subsribe  Приготовить перзентацию.
       Subscribe()

       just()
       mmapMap()
       map()
       from()
       doOnNext()*/
    Observable<String> doAuth (Context context, String action, String email, String password, String lang, String timeZone, String devId);

}
