package com.example.cinek.bmi;

/**
 * Created by Cinek on 14.03.2018.
 */

public class BmiForImperial extends BMI {

    public BmiForImperial(double mass, double height) {
        super(mass, height);
    }
    @Override
    public double countBMI() {
        if (!dataAreValid()) throw new IllegalArgumentException(BMI.INVALID_ARG_EX_MESSAGE);
        return mass / (height * height) * 703;
    }

    @Override
    protected boolean dataAreValid() {
        return mass > 0 && height > 0;
    }
}
