package com.example.cinek.bmi;

import android.graphics.Color;

/**
 * Created by Cinek on 01.03.2018.
 */

public abstract class BMI {

    private static final double MIN_MASS = 5;
    private static final double MAX_MASS = 1000;
    private static final double MIN_HEIGHT = 0.5;

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    private static final double MAX_HEIGHT = 3.0;

    private double mass;
    private double height;

    public BMI(double mass, double height) {
        this.mass = mass;
        this.height = height;
    }

    public int getColorInt() {
        double bmi = countBMI();
        if (bmi < 18.5) return Color.BLUE;
        if (bmi >= 25.0) return Color.RED;
        return Color.GREEN;
    }

    abstract public double countBMI();

    abstract protected boolean dataAreValid();


}
