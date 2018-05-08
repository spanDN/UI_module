package com.example.delle5540.ui_module.app;

import android.app.Application;

import com.example.delle5540.ui_module.commons.IBasePresenter;
import com.example.delle5540.ui_module.interactors.IBaseInteractor;
import com.example.delle5540.ui_module.presenters.AuthPresenterImpl;
import com.example.delle5540.ui_module.presenters.SplashPresenteImpl;
import com.example.delle5540.ui_module.realm_helper.IRealmUtils;
import com.example.delle5540.ui_module.utils.Validator.IValidator;
import com.example.delle5540.ui_module.utils.networkCheck.INetworkCheck;

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

    @Provides
    @AppScope
    IBasePresenter.IAuthPresenter providesAuthPresenterImpl(Application application, IValidator validator, INetworkCheck nCheck,
                                                             IBaseInteractor.IInteractor baseInteractor, IRealmUtils realmutils){
        return new AuthPresenterImpl(application, validator, nCheck, baseInteractor, realmutils);
    }
}
