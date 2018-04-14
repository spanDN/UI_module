package com.example.delle5540.ui_module.presenters;

import android.app.Application;

import com.example.delle5540.ui_module.commons.BasePresenter;
import com.example.delle5540.ui_module.commons.IBasePresenter;
import com.example.delle5540.ui_module.commons.IBaseView;
import com.example.delle5540.ui_module.interactors.IBaseInteractor;
import com.example.delle5540.ui_module.model.User;
import com.example.delle5540.ui_module.realm_helper.IRealmUtils;

/**
 * Created by dell e5540 on 4/14/2018.
 */

public class SplashPresenteImpl extends BasePresenter<IBaseView.ISplashView, IBaseInteractor.IInteractor>
        implements IBasePresenter.ISplashPresenter{

    public SplashPresenteImpl(Application application, IRealmUtils realmUtils) {
        this.application = application;
        this.realmUtils = realmUtils;
    }

    @Override
    public void init(IBaseView.ISplashView v) {
        super.init(v);
    }

    @Override
    public void doCheckUserData() {
        realmUtils.getObject(1, User.class).subscribe(user ->{
           view.checkUserData(user != null);
        });
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
