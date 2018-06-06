package com.example.framgiahangoclong.demodagger;

import javax.inject.Inject;

public class Gun implements Weapon {

    @Inject
    public Gun() {

    }

    @Override
    public void function() {
        System.out.println("shoot");
    }

}
