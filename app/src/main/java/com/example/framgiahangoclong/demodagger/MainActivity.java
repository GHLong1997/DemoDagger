package com.example.framgiahangoclong.demodagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    public Soldier mSoldier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainComponent.builder().mainModule(new MainModule()).build().inject(this);
        mSoldier.action();
    }
}
