package com.example.delle5540.ui_module.app;

import com.example.delle5540.ui_module.commons.InteractorImpl;
import com.example.delle5540.ui_module.interactors.IBaseInteractor;

import dagger.Module;

/**
 * Created by dell e5540 on 3/24/2018.
 */
@Module
public class ApiModule {


    IBaseInteractor.IInteractor providesInteractor() {
        return new InteractorImpl();
    }
}
