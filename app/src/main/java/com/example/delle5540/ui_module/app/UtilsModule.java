package com.example.delle5540.ui_module.app;

import android.app.Application;

import com.example.delle5540.ui_module.utils.networkCheck.INetworkCheck;
import com.example.delle5540.ui_module.utils.Validator.IValidator;
import com.example.delle5540.ui_module.utils.networkCheck.NetworkCheckImpl;
import com.example.delle5540.ui_module.utils.Validator.ValidatorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dell e5540 on 3/24/2018.
 */
@Module
public class UtilsModule {

    @Provides
    @AppScope
    IValidator providesValidator (){
        return new ValidatorImpl();
    }

    @Provides
    @AppScope
    INetworkCheck providesNetworkCheck (Application application){
        return new NetworkCheckImpl(application);
    }
}
