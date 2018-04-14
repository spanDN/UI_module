package com.example.delle5540.ui_module.auth_operation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.delle5540.ui_module.R;
import com.example.delle5540.ui_module.activities.MainActivity;
import com.example.delle5540.ui_module.commons.IBasePresenter;
import com.example.delle5540.ui_module.commons.IBaseView;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity implements IBaseView.ISplashView{

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Inject
    IBasePresenter.ISplashPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_splash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        presenter.init(this);
    }

    @Override
    public void checkUserData(boolean is) {
        if(is){
            new Handler().postDelayed(() -> { Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class); SplashActivity.this.startActivity(mainIntent); SplashActivity.this.finish(); }, SPLASH_DISPLAY_LENGTH);
        }else {
            new Handler().postDelayed(() -> { Intent mainIntent = new Intent(SplashActivity.this, NavigationActivity.class); SplashActivity.this.startActivity(mainIntent); SplashActivity.this.finish(); }, SPLASH_DISPLAY_LENGTH);
        }
    }

    @Override
    public void showMessage(String s) {

    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
