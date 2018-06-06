package com.example.framgiahangoclong.demodagger;

import javax.inject.Inject;

public class Knife implements Weapon{

    @Inject
    public Knife() {

    }

    @Override
    public void function() {
        System.out.println("stab");
    }
}
