package com.example.delle5540.ui_module.app;

import android.app.Application;

import com.example.delle5540.ui_module.commons.IBasePresenter;
import com.example.delle5540.ui_module.presenters.SplashPresenteImpl;
import com.example.delle5540.ui_module.realm_helper.IRealmUtils;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dell e5540 on 4/14/2018.
 */
@Module
public class PresenterModule {
    @Provides
    @AppScope
    IBasePresenter.ISplashPresenter providesSplashPresenter(Application application, IRealmUtils realmUtils){
        return new SplashPresenteImpl(application, realmUtils);
    }
}
