package com.example.cinek.bmi;

/**
 * Created by Cinek on 14.03.2018.
 */

public class BmiForImperial extends BMI {

    @Override
    public double countBMI(double mass, double height) {
        if (!dataAreValid(mass, height)) throw new IllegalArgumentException("Invalid argument");
        return mass / (height * height) * 703;
    }

    @Override
    protected boolean dataAreValid(double mass, double height) {
        return mass > 0 && height > 0;
    }
}
