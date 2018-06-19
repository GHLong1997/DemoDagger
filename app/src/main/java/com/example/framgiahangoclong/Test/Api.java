package com.example.framgiahangoclong.Test;

import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface Api {

    @Headers("asdasd: sadad")
    @GET("google/followers")
    Call<List<User>> getUser();

    @GET
    Call<NewUser> getNewUserViaNewUrl(@Url  String url);

    @GET()
    Call<User> getUser1(@Url String url);

    @GET()
    Call<ResponseBody> getUser(@Url String url);
}
