package com.example.delle5540.ui_module.app;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import javax.annotation.PostConstruct;


import rx.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


/**
 * Created by dell e5540 on 5/3/2018.
 */

public interface ObscureApi {
    @FormUrlEncoded
    @POST("/sign_in")
    Observable<JsonObject> signIN(@Field("email") String Email, @Field("password") String password);

    @POST("/")
    Observable<Response<ResponseBody>> commonRequest(@Header("Content-Type") String contentType,
                                                     @Header("action") String action,
                                                     @Header("authkey") String token,
                                                     @Header("Accept-Language") String language,
                                                     @Header("Time-Zone") String timeZone,
                                                     @Body RequestBody body);
//    @POST("/")
//    Observable<Response<ResponseBody>> signIn(@Field("email") String email,
//                                              @Field("password") String password );

//    @FormUrlEncoded
    @POST("sign_in")
    Observable<Response<ResponseBody>> signIn(@Body RequestBody body);

    @Multipart
    @POST("/")
    Observable<ResponseBody> uploadFile(  @Header("action") String action,
                                                     @Header("authkey") String token,
                                                     @Part MultipartBody.Part file);

    @Multipart
    @POST("/")
    Observable<ResponseBody> uploadArrayFiles(  @Header("action") String action,
                                                    @Header("authkey") String token,
                                                    @Part List<MultipartBody.Part> files);
}
