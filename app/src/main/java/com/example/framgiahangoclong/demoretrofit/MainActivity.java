package com.example.framgiahangoclong.demoretrofit;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        LoginService loginService =
                ServiceGenerator.createService(LoginService.class, "GHLong1997", "Aa640496854");
        Call<User> call = loginService.basicLogin();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    // user object available
                    User user = response.body();
                    Log.d("haha", "onResponse: " + user.getEmail());
                } else {
                    // error response, no access to resource?
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });

        //        Call<NewUser> call = api.getNewUserViaNewUrl
        // ("https://fierce-cove-29863.herokuapp.com/getAnUser/2");
        //        call.enqueue(new Callback<NewUser>() {
        //            @Override
        //            public void onResponse(Call<NewUser> call, Response<NewUser> response) {
        //                Log.d("h", "onResponse: " + response.body().toString());
        //            }
        //
        //            @Override
        //            public void onFailure(Call<NewUser> call, Throwable t) {
        //
        //            }
        //        });

        //        api.getUser1("google/followers").enqueue(new Callback<User>() {
        //            @Override
        //            public void onResponse(Call<User> call, Response<User> response) {
        //                user = response.body();
        //                Log.d("hhh", "onResponse: " + user.toString());
        //            }
        //
        //            @Override
        //            public void onFailure(Call<User> call, Throwable t) {
        //
        //            }
        //        });

        //        api.getUser("google/followers").enqueue(new Callback<ResponseBody>() {
        //            @Override
        //            public void onResponse(Call<ResponseBody> call, Response<ResponseBody>
        // response) {
        //                Log.d("kaka", "onResponse: " + response.body().toString());
        //            }
        //
        //            @Override
        //            public void onFailure(Call<ResponseBody> call, Throwable t) {
        //
        //            }
        //        });

        //        Disposable disposable = api.getUser()
        //                .subscribeOn(Schedulers.io())
        //                .observeOn(AndroidSchedulers.mainThread())
        //                .subscribe(new Consumer<List<User>>() {
        //                    @Override
        //                    public void accept(List<User> users) throws Exception {
        //
        //                    }
        //                }, new Consumer<Throwable>() {
        //                    @Override
        //                    public void accept(Throwable throwable) throws Exception {
        //
        //                    }
        //                });
        //
        //        Api api = ServiceGenerator1.createService(this, Api.class);
        //        api.getUser().enqueue(new Callback<List<User>>() {
        //            @Override
        //            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
        //
        //                if (response.isSuccessful()) {
        //
        //                    if (response.raw().cacheResponse() != null) {
        //                        // true: response was served from cache
        //                    }
        //
        //                    if (response.raw().networkResponse() != null) {
        //                        // true: response was served from network/server
        //                    }
        //
        //                }else {
        //                    //error response, no access to r
        //                }
        //            }
        //
        //            @Override
        //            public void onFailure(Call<List<User>> call, Throwable t) {
        //
        //            }
        //        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Drawable drawable = item.getIcon();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        switch (item.getItemId()) {
            case R.id.action_cut:
                return true;
            case R.id.action_copy:
                return true;
            case R.id.action_share:
                return true;
            case R.id.action_delete:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
