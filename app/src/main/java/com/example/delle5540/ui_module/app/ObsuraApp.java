package com.example.delle5540.ui_module.app;

import android.app.Application;

import com.example.delle5540.ui_module.app.ApiModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by dell e5540 on 3/13/2018.
 */

public class ObsuraApp extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .utilsModule(new UtilsModule())
                .apiModule(new ApiModule())
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.initAppComponent();
        this.initRealmConfiguration();

    }

    private void initRealmConfiguration() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).schemaVersion(1).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
