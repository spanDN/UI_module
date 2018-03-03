package com.example.delle5540.ui_module.commons;

/**
 * Created by dell e5540 on 1/11/2018.
 */

public interface IAuthListener {
    void signIn(String email, String password);
    void signUp(String email, String password, String repeatPassword);
    void resetAccount(String email);
    void openSignIn();
    void openSignUp();
    void openReset();
    void loginSocial(int type);
 //   void sendtoPresenterCallBack(ICallback ic);
}
