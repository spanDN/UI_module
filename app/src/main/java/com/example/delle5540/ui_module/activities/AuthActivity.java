package com.example.delle5540.ui_module.activities;


import android.os.Bundle;
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


public class AuthActivity extends AppCompatActivity implements IBaseView.IAuthView {

    IBasePresenter.IAuthPresenter presenter; // Define object of interface type

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        getSupportFragmentManager().beginTransaction().replace(R.id.auth_content,
                SignInFragment.newInstance(onAuthListener)).commit();
        presenter = new AuthPresenterImpl(); // Instantiate ointerface object
        presenter.init(this); // Need to pass IBaseView.IAuthView
    }
    /*  Methods which are used in fragment to send info to activity */
    private IAuthListener onAuthListener = new IAuthListener() {
        @Override
        public void signIn(String email, String password) {
            /* Activity sends data to presenter */
            presenter.signIn(email,password, AuthActivity.this);
        }

        @Override
        public void signUp(String email, String password, String repeatPassword) {
            presenter.signUp(email, password, repeatPassword, AuthActivity.this);
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
        Toast.makeText(AuthActivity.this, s, Toast.LENGTH_LONG ).show();

    }

    @Override
    public void showError(String s) {
        Toast.makeText(AuthActivity.this, s, Toast.LENGTH_LONG ).show();

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

