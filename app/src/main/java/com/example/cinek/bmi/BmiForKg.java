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
            return getMass() / (getHeight() * getHeight());
        } else {
            throw new IllegalArgumentException("Invalid data");
        }
    }

    @Override
    protected boolean dataAreValid() {
        return getMass() > 0 && getHeight() > 0;
    }
}
