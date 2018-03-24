package com.example.delle5540.ui_module.app;

import com.example.delle5540.ui_module.commons.InteractorImpl;
import com.example.delle5540.ui_module.interactors.IBaseInteractor;
import com.example.delle5540.ui_module.interactors.IInteractor;

import dagger.Module;

/**
 * Created by dell e5540 on 3/24/2018.
 */
@Module
public class ApiModule {


    IBaseInteractor.IAuthInteractor providesInteractor() {
        return new InteractorImpl();
    }
}
