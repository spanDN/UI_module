package com.example.delle5540.ui_module.commons;

import android.content.Intent;
import android.util.Log;

import com.example.delle5540.ui_module.R;
import com.example.delle5540.ui_module.interactors.IBaseInteractor;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by dell e5540 on 3/6/2018.
 */

public class MainPresenterImpl extends BasePresenter<IBaseView.IMainView, IBaseInteractor.IInteractor> implements IMainPresenter {

    private CallbackManager callbackManager;
    ArrayList<String> urls = new ArrayList<String>();

    @Override
    public void doLogout(String token, int type) {

            callbackManager = CallbackManager.Factory.create();
            Log.d("SOCIAL", "AfterCallBackManager");
            if (AccessToken.getCurrentAccessToken() == null) {
                Log.d("SOCIAL", "NUll");
                return;
            } else {
                Log.d("SOCIAL", "Has token, go logout " + AccessToken.getCurrentAccessToken().getToken());
                LoginManager.getInstance().logOut();
                if (AccessToken.getCurrentAccessToken() == null) {
                    Log.d("SOCIAL", "Logged out ");
                    /* How I can find activity here */
                    /* onBackPressed() */
                    view.closeMain();

                }
            }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void init(IBaseView.IMainView view) {
        super.init(view);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void uploadFile(File fileTest) {
        if (!networkCheck.doNetworkCheck()) {
            view.showError(application.getString(R.string.error_text_no_internet));
            return;
        }

        MediaType mediaType = MediaType.parse("image/jpeg");
        RequestBody requestBodyFile2 = RequestBody.create(mediaType, fileTest);
        try {
            Log.d("RETy", "FillProfilePresenterImpl uploadFile(), requestBodyFile2.contentLength() "
                    + requestBodyFile2.contentLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
        MultipartBody.Part multipartBody =
                MultipartBody.Part.createFormData("avatar",
                        fileTest.getName(), requestBodyFile2);
        interactor.uploadFile("upload_avatar", "", multipartBody)
                .subscribe(next -> {
                            Log.d("RETy", "FillProfilePresenterImpl uploadFile(), " +
                                    "onNext() " + next.toString());
                        }, throwable -> {
                            Log.d("RETy", "FillProfilePresenterImpl uploadFile(), " +
                                    "onNext() " + throwable.getMessage());
                        }
                );

    }

    @Override
    public void addUri(String input_uri) {
        urls.add(input_uri);
    }

    private List<MultipartBody.Part> getListMultiParts() {
        ArrayList<File> files = new ArrayList<>();
        for (String url : urls) {
            File file = new File(url);
            if (file.exists()) {
                files.add(file);
            }
        }
        MediaType mediaType = MediaType.parse("image/jpeg");
        RequestBody requestBodyFile2;
        MultipartBody.Part multipartBody;
        List<MultipartBody.Part> multipartList = new ArrayList<>();

        for (int i = 0; i < files.size(); i++) {
            requestBodyFile2 = RequestBody.create(mediaType, files.get(i));
            try {
                Log.d("RETy", "CreatePostPresenterImpl doOnSavePost(), requestBodyFile2.contentLength() " + requestBodyFile2.contentLength());
            } catch (IOException e) {
                Log.d("RETy", "CreatePostPresenterImpl doOnSavePost(), IOException " + e.getMessage());
                e.printStackTrace();
            }
            multipartBody = MultipartBody.Part.createFormData("files[" + i + "][file]", files.get(i).getName(), requestBodyFile2);
            multipartList.add(multipartBody);
            Log.d("RETy", "CreatePostPresenterImpl doOnSavePost(), multipartList.size() " + multipartList.size());
        }
        return multipartList;
    }

    public void doUploadFiles(String action, String timeZone, String lang)
    {
        if (!networkCheck.doNetworkCheck()) {
            view.showError(application.getString(R.string.error_text_no_internet));
            return;
        }
        List<MultipartBody.Part> multiParts = this.getListMultiParts();
        interactor.uploadFiles("", "", multiParts).subscribe();
    }
}
