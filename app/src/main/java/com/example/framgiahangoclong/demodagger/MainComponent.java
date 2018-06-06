package com.example.framgiahangoclong.demodagger;

import dagger.Component;

@ActivityScope
@Component(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
