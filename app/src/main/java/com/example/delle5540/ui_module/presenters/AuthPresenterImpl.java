package com.example.delle5540.ui_module.presenters;

import android.content.Context;
import android.widget.Toast;

import com.example.delle5540.ui_module.commons.BasePresenter;
import com.example.delle5540.ui_module.commons.IBasePresenter;
import com.example.delle5540.ui_module.commons.IBaseView;

/**
 * Created by dell e5540 on 2/6/2018.
 */

public class AuthPresenterImpl extends BasePresenter<IBaseView> implements IBasePresenter.IAuthPresenter<IBaseView.IAuthView> {


    @Override
    public void dismiss() {
        super.dissmiss();
    }

    @Override
    public void loginSocial(int type, Context context) {
        view.showMessage ("LoginSocial");
    }

    @Override
    public void signIn(String email, String password, Context context) {
        Toast.makeText(context, "signIn presenter\n ", Toast.LENGTH_LONG ).show();
    }

    @Override
    public void signUp(String email, String password, String repeatPassword, Context context) {
        Toast.makeText(context, "signUp presenter\n ", Toast.LENGTH_LONG ).show();
    }

    @Override
    public void resetAccount(String email, Context context) {
        Toast.makeText(context, "resetAccount\n ", Toast.LENGTH_LONG ).show();
    }

    @Override
    public void init(IBaseView.IAuthView view) {
        super.init(view);
    }
}
