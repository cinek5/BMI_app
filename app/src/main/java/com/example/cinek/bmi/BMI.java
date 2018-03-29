package com.example.cinek.bmi;

import android.graphics.Color;

/**
 * Created by Cinek on 01.03.2018.
 */

public abstract class BMI {
    double mass;
    double height;
    public static String INVALID_ARG_EX_MESSAGE = "Invalid argument";
    
    public BMI(double mass, double height) {
        this.mass = mass;
        this.height = height;
    }


    public int getColorInt() {
        double bmi = countBMI();
        if (bmi < 0) throw new IllegalArgumentException(BMI.INVALID_ARG_EX_MESSAGE);
        if (bmi < 18.5) return Color.BLUE;
        if (bmi >= 25.0) return Color.RED;
        return Color.GREEN;
    }

    abstract public double countBMI();

    abstract protected boolean dataAreValid();


}
