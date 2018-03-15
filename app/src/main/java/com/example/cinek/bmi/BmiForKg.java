package com.example.cinek.bmi;

/**
 * Created by Cinek on 08.03.2018.
 */

public class BmiForKg extends BMI {


    @Override
    public double countBMI(double mass, double height) {
        if (dataAreValid(mass, height)) {
            return mass / (height * height);
        } else {
            throw new IllegalArgumentException("Invalid data");
        }
    }

    @Override
    protected boolean dataAreValid(double mass, double height) {
        return mass > 0 && height > 0 && height < 3 && mass < 500;
    }
}
