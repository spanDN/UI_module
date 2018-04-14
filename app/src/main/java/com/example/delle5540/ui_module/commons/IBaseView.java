package com.example.delle5540.ui_module.commons;

import com.example.delle5540.ui_module.activities.MainActivity;
import com.example.delle5540.ui_module.interactors.IBaseInteractor;

/**
 * Created by dell e5540 on 1/27/2018.
 */

public interface IBaseView {
    void showMessage(String s);
    void showError(String s);
    void showProgressBar();
    void hideProgressBar();

    interface IAuthView extends IBaseView {
        void openMain(String token);
    }
    interface IMainView extends IBaseView {
        void doneLogout(String token, int type);
        void closeMain();
    }

    interface ISplashView extends IBaseView {
        void checkUserData(boolean is);
    }

 /* Сделать интерфейс отдельным классом *
    IMainPresenter {
        doLogout(Token, Type);
    }
 /*                                     */
  /*
    Создать MainPresenterImpl() implements IPresenterContract.IMainPresenter {
        Добавить dissmis() и init()
    }
    В новой MainActivity добавить 3 инконки и сделать по ним logout.
    */
}
