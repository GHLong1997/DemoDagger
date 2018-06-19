package com.example.framgiahangoclong.Query;

import android.content.Context;
import android.support.annotation.NonNull;
import com.example.framgiahangoclong.demoretrofit.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator1 {

    private static final int CONNECTION_TIMEOUT = 60;
    private static final String BASE_URL = "https://api.github.com/users/";


   public static <T> T createService(Context context, Class<T> serviceClass) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        httpClientBuilder.cache(
                new Cache(context.getApplicationContext().getCacheDir(), cacheSize));

        httpClientBuilder.readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
//        httpClientBuilder.addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request original = chain.request();
//                HttpUrl originalHttpUrl = original.url();
//
//                HttpUrl url = originalHttpUrl.newBuilder()
//                        .addQueryParameter("client_id", "e8f689ef78fb29240604e1c2df71b45a")
//                        .addQueryParameter("linked_partitioning", "1")
//                        .build();
//
//                // Request customization: add request headers
//                Request.Builder requestBuilder = original.newBuilder()
//                        .url(url);
//
//                Request request = requestBuilder.build(); //Once you’ve added your query parameter,
//                // use the .build() method to create the new HttpUrl object which is added to the request by using the Request.Builder
//                return chain.proceed(request);
//            }
//        });
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            httpClientBuilder.addInterceptor(logging);
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        Retrofit retrofit = builder.client(httpClientBuilder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }
}
