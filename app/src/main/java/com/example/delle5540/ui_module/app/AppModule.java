package com.example.delle5540.ui_module.app;

import android.app.Application;

import com.example.delle5540.ui_module.shared_preferences.ISharedUtils;
import com.example.delle5540.ui_module.shared_preferences.SharedPreferenceUtilsImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dell e5540 on 3/13/2018.
 */
@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @AppScope
    public Application provideApplication() {
        return application;
    }

    @Provides
    @AppScope
    public ISharedUtils provideSharedPreUtils(Application app) {
        return new SharedPreferenceUtilsImpl(app);
    }
}
