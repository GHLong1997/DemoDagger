package com.example.framgiahangoclong.demodagger;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @ActivityScope
    @Provides
    public Soldier provideSoldier(Gun gun, Knife knife) {
        return new Soldier(gun, knife);
    }
}
