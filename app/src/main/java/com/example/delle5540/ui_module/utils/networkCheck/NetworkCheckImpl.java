package com.example.delle5540.ui_module.utils.networkCheck;

import android.app.Application;
import android.net.ConnectivityManager;
import 	android.net.NetworkInfo;
import android.content.Context;
import android.annotation.SuppressLint;

/**
 * Created by dell e5540 on 3/24/2018.
 */

public class NetworkCheckImpl implements INetworkCheck {
    public Application application;

    public NetworkCheckImpl(Application application) {
    }

    @Override
    public boolean doNetworkCheck() {
        ConnectivityManager connectivityMgr = (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission")
        NetworkInfo networkInfo = connectivityMgr.getActiveNetworkInfo(); /// if no network is available networkInfo will be null
     if (networkInfo != null && networkInfo.isConnected()) { return true; } return false; }
}

