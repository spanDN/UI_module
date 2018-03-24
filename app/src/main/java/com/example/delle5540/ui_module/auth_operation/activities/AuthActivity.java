package com.example.delle5540.ui_module.auth_operation.activities;


import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.delle5540.ui_module.ObscuraApp;
import com.example.delle5540.ui_module.app.ObsuraApp;
import com.example.delle5540.ui_module.R;
import com.example.delle5540.ui_module.activities.MainActivity;
import com.example.delle5540.ui_module.auth_operation.fragments.ResetFragment;
import com.example.delle5540.ui_module.auth_operation.fragments.SignInFragment;
import com.example.delle5540.ui_module.auth_operation.fragments.SignUpFragment;
import com.example.delle5540.ui_module.commons.IAuthListener;
import com.example.delle5540.ui_module.commons.IBasePresenter;
import com.example.delle5540.ui_module.commons.IBaseView;
import com.example.delle5540.ui_module.commons.InteractorImpl;
import com.example.delle5540.ui_module.commons.SocialType;
import com.example.delle5540.ui_module.presenters.AuthPresenterImpl;
import com.example.delle5540.ui_module.interactors.IBaseInteractor;

import java.util.GregorianCalendar;
import java.util.Locale;

import com.example.delle5540.ui_module.utils.Validator.IValidator;
import com.example.delle5540.ui_module.utils.networkCheck.INetworkCheck;
import com.facebook.appevents.AppEventsLogger;

/* Need for generating  HASH KEY*/
import 	android.content.pm.PackageManager;
import android.content.pm.PackageInfo;
import 	android.content.pm.Signature;
import 	java.security.MessageDigest;
import android.util.Base64;

import javax.inject.Inject;
/* ******************************* */




public class  AuthActivity extends AppCompatActivity implements IBaseView.IAuthView {

    IBasePresenter.IAuthPresenter presenter; // Define object of interface type
    private String timeZone, language, deviceId;
    /* Dagger injection */
    @Inject
    Application application;
    INetworkCheck networkCheck;
    IValidator validator;
    IBaseInteractor.IInteractor interactor;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ((ObsuraApp)getApplication()).getAppComponent().inject(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.auth_content,
                SignInFragment.newInstance(onAuthListener)).commit();

        GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
        this.timeZone = cal.getTimeZone().getDisplayName();
        this.language = Locale.getDefault().getDisplayLanguage();
        this.deviceId = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);

        presenter = new AuthPresenterImpl(application, validator, networkCheck,  interactor);
        presenter.init(this); // Need to pass IBaseView.IAuthView

        AppEventsLogger.activateApp(this);
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.delle5540.ui_module",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {

        } catch (java.security.NoSuchAlgorithmException e) {

        }
    }

    /*  Methods which are used in fragment to send info to activity */
    private IAuthListener onAuthListener = new IAuthListener() {
        @Override
        public void signIn(String email, String password) {
            /* Activity sends data to presenter */
            /*  void signIn( String email, String password, String lang, String timeZone, String devID, Context context); */
            presenter.signIn(email, password,language, timeZone, deviceId, AuthActivity.this);
        }

        @Override
        public void signUp(String email, String password, String repeatPassword) {
      //      void signUp(String email, String password, String repeatPassword, String lang, String timeZone, String devID, Context
       //      context);
            presenter.signUp(email, password, repeatPassword, language, timeZone, deviceId, AuthActivity.this);
        }

        @Override
        public void resetAccount(String email) {
            presenter.resetAccount(email, AuthActivity.this);
        }

        @Override
        public void openSignIn() {

        }

        @Override
        public void openSignUp() {
            getSupportFragmentManager().beginTransaction().replace(R.id.auth_content,
                    SignUpFragment.newInstance(onAuthListener)).commit();
        }

        @Override
        public void openReset() {
            //    DialogFragment example
            //  ResetFragment.newInstance(onAuthListener).show(AuthActivity.this.getSupportFragmentManager(), "save filter");
            getSupportFragmentManager().beginTransaction().replace(R.id.auth_content,
                    ResetFragment.newInstance(onAuthListener)).commit();
        }

        @Override
        public void loginSocial(int type) {
            switch (type) {
                case SocialType.FACEBOOK:
                    presenter.loginWithFB(AuthActivity.this);
                    break;
                case SocialType.GOOGLE:
                    presenter.loginWithGoogle(AuthActivity.this);
                    break;
                case SocialType.TWITER:
                    presenter.loginWithTwiter(AuthActivity.this);
                    break;
            }
        }


    };

    /* Here we implemeting interface which  */
    @Override
    public void showMessage(String s) {
        Toast.makeText(AuthActivity.this, s, Toast.LENGTH_LONG).show();

    }

    @Override
    public void showError(String s) {
        Toast.makeText(AuthActivity.this, s, Toast.LENGTH_LONG).show();

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void openMain(String token) {
        ((ObscuraApp) getApplication()).setFacebookToken(token); // How we can do this.
        Intent i = new Intent(AuthActivity.this, MainActivity.class);
        startActivity(i);
//        overridePendingTransition();
    }
}

