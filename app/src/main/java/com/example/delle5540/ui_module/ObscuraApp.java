package com.example.delle5540.ui_module;

import android.app.Application;

/**
 * Created by dell e5540 on 3/4/2018.
 */

public class ObscuraApp extends Application{
    private String FacebookToken;
    private String GoogleToken;
    private String TwitterToken;

    public String getFacebookToken() {
        return FacebookToken;
    }

    public void setFacebookToken(String facebookToken) {
        FacebookToken = facebookToken;
    }

    public String getGoogleToken() {
        return GoogleToken;
    }

    public void setGoogleToken(String googleToken) {
        GoogleToken = googleToken;
    }

    public String getTwitterToken() {
        return TwitterToken;
    }

    public void setTwitterToken(String twitterToken) {
        TwitterToken = twitterToken;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}

