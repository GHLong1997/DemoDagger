package com.example.framgiahangoclong.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The ServiceGenerator class uses Retrofit’s Retrofit builder
 * to create a new REST client with the given API base url (BASE_URL)
 *
 * The createService method takes a serviceClass(annotated as interface for API request) ->
 * create a rest Adapter (client)
 */

/**
 *The createService method takes a serviceClass(annotated as interface for API request) -> create
 *  a rest Adapter (client)
 */

/**
 * Why Is Everything Declared Static Within this class: we want to use the same objects
 * (OkHttpClient, Retrofit, …)
 */

/**
 * overriding header: If already existing header with same key,
 */
public class ServiceGenerator {

    private static final String BASE_URL = "https://api.github.com/users/";

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);



    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addInterceptor(new HeaderInterceptor());

    public static <S> S createService(Class<S> serviceClass) {
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }

        return retrofit.create(serviceClass);
    }
}
