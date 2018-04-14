package com.example.delle5540.ui_module.app;

/**
 * Created by dell e5540 on 3/13/2018.
 */

import com.example.delle5540.ui_module.auth_operation.activities.AuthActivity;
import com.example.delle5540.ui_module.auth_operation.activities.SplashActivity;

import dagger.Component;

@AppScope
@Component(
        modules = {
                AppModule.class,
                UtilsModule.class,
                ApiModule.class,
                PresenterModule.class
        }
)

public interface AppComponent {
    void inject(SplashActivity activity);
    void inject(AuthActivity activity);
}
