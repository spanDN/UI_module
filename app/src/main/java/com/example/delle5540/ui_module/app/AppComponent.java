package com.example.delle5540.ui_module.app;

/**
 * Created by dell e5540 on 3/13/2018.
 */

import com.example.delle5540.ui_module.auth_operation.activities.AuthActivity;

import dagger.Component;

@AppScope
@Component(
        modules = {
                AppModule.class,
                UtilsModule.class,
                ApiModule.class
        }
)

public interface AppComponent {
    void inject(AuthActivity activity);
}
