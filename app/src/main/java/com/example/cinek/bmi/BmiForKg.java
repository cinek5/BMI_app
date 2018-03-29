package com.example.cinek.bmi;

/**
 * Created by Cinek on 08.03.2018.
 */

public class BmiForKg extends BMI {

    public BmiForKg(double mass, double height) {
        super(mass, height);
    }
    @Override
    public double countBMI() {
        if (dataAreValid()) {
            return mass / (height * height);
        } else {
            throw new IllegalArgumentException(BMI.INVALID_ARG_EX_MESSAGE);
        }
    }

    @Override
    protected boolean dataAreValid() {
        return mass > 0 && height > 0 && height < 3 && mass < 500;
    }
}
