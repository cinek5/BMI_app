package com.example.cinek.bmi;

import android.graphics.Color;

/**
 * Created by Cinek on 01.03.2018.
 */

public abstract class BMI {


    public int getColorInt(double bmi) {
        if (bmi < 0) throw new IllegalArgumentException("Invalid bmi argument");
        if (bmi < 18.5) return Color.BLUE;
        if (bmi >= 25.0) return Color.RED;
        return Color.GREEN;
    }

    abstract public double countBMI(double mass, double height);

    abstract protected boolean dataAreValid(double mass, double height);


}
