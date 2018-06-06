package com.example.framgiahangoclong.demodagger;

import javax.inject.Inject;

public class Soldier {

    private Gun mGun;
    private Knife mKnife;

    @Inject
    public Soldier(Gun gun, Knife knife) {
        mGun = gun;
        mKnife = knife;
    }

    public void action() {
        mGun.function();
        mKnife.function();
    }
}
