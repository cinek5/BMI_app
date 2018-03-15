package com.example.cinek.bmi;

import android.graphics.Color;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BmiUnitTest {
    @Test
    public void for_valid_mass_and_height_should_return_correct_value() {
        BMI bmiCounter = new BmiForKg();
        double bmi = bmiCounter.countBMI(60, 1.7);
        assertEquals(20.761, bmi, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void for_zero_mass_and_height_should_throw_exception() {
        BMI bmiCounter = new BmiForKg();
        double bmi = bmiCounter.countBMI(0, 0);
        assertEquals(20.761, bmi, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void for_minus_mass_and_height_should_throw_exception() {
        BMI bmiCounter = new BmiForKg();
        double bmi = bmiCounter.countBMI(-1, -1);
        assertEquals(20.761, bmi, 0.001);
    }

    @Test
    public void for_normal_bmi_should_return_green_color() {
        BMI bmiCounter = new BmiForKg();
        double bmi = bmiCounter.countBMI(70, 1.8);
        assertEquals(Color.GREEN, bmiCounter.getColorInt(bmi));

    }

    @Test
    public void for_less_than_normal_bmi_should_return_blue_color() {
        BMI bmiCounter = new BmiForKg();
        double bmi = bmiCounter.countBMI(40, 1.8);
        assertEquals(Color.BLUE, bmiCounter.getColorInt(bmi));

    }

    @Test
    public void for_more_than_normal_bmi_should_return_red_color() {
        BMI bmiCounter = new BmiForKg();
        double bmi = bmiCounter.countBMI(120, 1.8);
        assertEquals(Color.RED, bmiCounter.getColorInt(bmi));

    }
}