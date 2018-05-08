package com.example.delle5540.ui_module.app;

import android.app.Application;
import android.util.Config;

import com.example.delle5540.ui_module.R;
import com.example.delle5540.ui_module.commons.InteractorImpl;
import com.example.delle5540.ui_module.interactors.IBaseInteractor;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dell e5540 on 3/24/2018.
 */
@Module
public class ApiModule {

    @Provides
    @AppScope
    public OkHttpClient provideOkHttpClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (Config.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }

        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS);

        return builder.build();
    }

    @Provides
    @AppScope
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder
                .setLenient()
                .create();
    }

    @Provides
    @AppScope
    public Retrofit provideRestAdapter(Application application, Gson gson, OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient)
                .baseUrl(application.getString(R.string.base_url))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson));
        return builder.build();
    }

    @Provides
    @AppScope
    public ObscureApi provideApiService(Retrofit restAdapter) {
        return restAdapter.create(ObscureApi.class);
    }

    @Provides
    @AppScope
    public IBaseInteractor.IInteractor provideInteractor(ObscureApi apiService) {
        return new InteractorImpl(apiService);
    }
}
