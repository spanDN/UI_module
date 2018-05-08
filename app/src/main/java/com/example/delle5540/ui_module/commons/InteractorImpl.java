package com.example.delle5540.ui_module.commons;

import android.content.Context;
import android.util.Log;
import android.util.Patterns;

import com.example.delle5540.ui_module.app.ObscureApi;
import com.example.delle5540.ui_module.interactors.IBaseInteractor;
import com.example.delle5540.ui_module.model.AuthModel;
import com.example.delle5540.ui_module.model.BaseInteractor;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import okhttp3.MultipartBody;


/**
 * Created by dell e5540 on 2/15/2018.
 */

public class InteractorImpl extends BaseInteractor implements IBaseInteractor.IInteractor {

    private ObscureApi api;

    public InteractorImpl(ObscureApi api) {
        this.api = api;
    }

    private boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    public Observable<String> doAuth(Context context, String action, String email, String password, String lang, String timeZone, String devId) {

        AuthModel model = new AuthModel();
        model.setAction(action);
        model.setEmail(email);
        model.setPassword(password);
        model.setLang(lang);
        model.setDevId(devId);
        return Observable.just(model).flatMap(authModel -> {
            Log.d("InteractorImpl", "Observable model to string " + authModel.toString());
            if (isEmailValid(authModel.getEmail())) {
                Log.d("InteractorImpl", "Valid email");
                return Observable.just(authModel.getAction() + " success");
            } else {
                Log.d("InteractorImpl", "Invalid email");
                return Observable.just(authModel.getEmail() + "is not valid");
            }
        });
    }
    @Override
    public Observable<JsonObject> uploadFiles(String action, String authKeyOrEmail, List<MultipartBody.Part> part) {
        Log.d("RETy", "OneInteractorImpl uploadGalleryFiles() action " + action + ", authKey " + authKeyOrEmail + " part.size() " + part.size());

        return api.uploadArrayFiles(action, authKeyOrEmail, part) //image, //, description
                .doOnError(throwable -> Log.d("RETy", "OneInteractorImpl response error outside" + throwable.getMessage()))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(response -> {
                    try {
                        Log.d("RETy", "OneInteractorImpl response " + response);
                        String decode = decode(response.string());
                        Log.d("RETy", "OneInteractorImpl response decode " + decode);
                        JsonObject object = new Gson().fromJson(decode, JsonObject.class);
                        Log.d("RETy", "OneInteractorImpl response object " + object);
                        return new Gson().fromJson(decode, JsonObject.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
    }
    @Override
    public Observable<JsonObject> uploadFile(String action, String authKeyOrEmail, MultipartBody.Part part) {
        Log.d("RETy", "OneInteractorImpl uploadFile() action " + action + ", authKey " + authKeyOrEmail);
        return api.uploadFile(action, authKeyOrEmail, part) //image, //, description
                .doOnError(throwable -> Log.d("Account", "OneInteractorImpl response error outside" + throwable.getMessage()))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(response -> {
                    try {
                        Log.d("RETy", "OneInteractorImpl response " + response.string());
                        String decode = decode(response.string());
                        Log.d("RETy", "OneInteractorImpl response decode " + decode);
                        String json = this.decode(decode);
                        Log.d("RETy", "OneInteractorImpl response json " + json);
                        return new Gson().fromJson(json, JsonObject.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
    }
    @Override
    public Observable<JsonObject> signIn(String email, String password) {
        CommonRequest commonRequest = new CommonRequest(email, password);
        String json_to_decode = this.toJson(commonRequest);
        String encode = this.encode(json_to_decode);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"data\"" + encode + "}");
        return api.signIn(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(responseBodyResponse -> {
                    Log.d("RETy", "OneInteractorImpl doOnNext() response " + responseBodyResponse);
                    try {
                        String decode = responseBodyResponse.body().string();
                        Log.d("RETy", "OneInteractorImpl doOnNext() decode " + decode);
                        String json = this.decode(decode);

                        Log.d("RETy", "OneInteractorImpl doOnNext() json " + json);
                        Log.d("RETy", "OneInteractorImpl doOnNext() jsonObject "
                                + new Gson().fromJson(json, JsonObject.class));

                        return new Gson().fromJson(json, JsonObject.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .doOnError(throwable -> Log.d("CHOOSEPLACE", "OneInteractorImpl doOnError() " + throwable.getMessage()));
    }
}
