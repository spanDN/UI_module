package com.example.delle5540.ui_module.activities;


import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.delle5540.ui_module.R;
import com.example.delle5540.ui_module.commons.IAuthListener;
import com.example.delle5540.ui_module.commons.IBasePresenter;
import com.example.delle5540.ui_module.commons.IBaseView;
import com.example.delle5540.ui_module.fragments.ResetFragment;
import com.example.delle5540.ui_module.fragments.SignInFragment;
import com.example.delle5540.ui_module.fragments.SignUpFragment;
import com.example.delle5540.ui_module.presenters.AuthPresenterImpl;
import com.example.delle5540.ui_module.interactors.IBaseInteractor;
import com.example.delle5540.ui_module.commons.AuthInteractorImpl;
import java.util.GregorianCalendar;
import java.util.Locale;




public class  AuthActivity extends AppCompatActivity implements IBaseView.IAuthView {

    IBasePresenter.IAuthPresenter presenter; // Define object of interface type
    IBaseInteractor.IAuthInteractor interactor;
    private String timeZone, language, deviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        getSupportFragmentManager().beginTransaction().replace(R.id.auth_content,
                SignInFragment.newInstance(onAuthListener)).commit();

        GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
        this.timeZone = cal.getTimeZone().getDisplayName();
        this.language = Locale.getDefault().getDisplayLanguage();
        this.deviceId = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);

        interactor = new AuthInteractorImpl();
        presenter = new AuthPresenterImpl(getApplication(), interactor);
        presenter.init(this); // Need to pass IBaseView.IAuthView
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
        public void loginSocial() {
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
    public void openMain(boolean auth) {

    }
}

