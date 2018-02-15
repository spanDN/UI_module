package com.example.delle5540.ui_module.interactors;

import io.reactivex.Observable;

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
       from() */
    Observable<Boolean> doAuth (String action, String email, String password, String lang, String timeZone);

}
