package com.example.framgiahangoclong.demoretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginService {

        @GET("/user")
        Call<User> basicLogin();
}
