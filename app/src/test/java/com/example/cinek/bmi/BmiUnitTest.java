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
        BMI bmiCounter = new BmiForKg(60, 1.7);
        double bmi = bmiCounter.countBMI();
        assertEquals(20.761, bmi, 0.001);
    }

    @Test
    public void for_valid_mass_and_height_should_return_correct_value_imperial() {
        BMI bmiCounter = new BmiForImperial(154, 70);
        double bmi = bmiCounter.countBMI();
        assertEquals(22.0942, bmi, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void for_zero_mass_and_height_should_throw_exception() {
        BMI bmiCounter = new BmiForKg(0, 0);
        double bmi = bmiCounter.countBMI();
        assertEquals(20.761, bmi, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void for_zero_mass_and_height_should_throw_exception_imperial() {
        BMI bmiCounter = new BmiForImperial(0, 0);
        double bmi = bmiCounter.countBMI();
        assertEquals(20.761, bmi, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void for_minus_mass_and_height_should_throw_exception() {
        BMI bmiCounter = new BmiForKg(-1, -1);
        double bmi = bmiCounter.countBMI();
        assertEquals(20.761, bmi, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void for_minus_mass_and_height_should_throw_exception_imperial() {
        BMI bmiCounter = new BmiForImperial(-1, -1);
        double bmi = bmiCounter.countBMI();
        assertEquals(20.761, bmi, 0.001);
    }

    @Test
    public void for_normal_bmi_should_return_green_color() {
        BMI bmiCounter = new BmiForKg(70, 1.8);
        double bmi = bmiCounter.countBMI();
        assertEquals(Color.GREEN, bmiCounter.getColorInt());

    }

    @Test
    public void for_normal_bmi_should_return_green_color_imperial() {
        BMI bmiCounter = new BmiForImperial(154, 70);
        double bmi = bmiCounter.countBMI();
        assertEquals(Color.GREEN, bmiCounter.getColorInt());

    }

    @Test
    public void for_less_than_normal_bmi_should_return_blue_color() {
        BMI bmiCounter = new BmiForKg(40, 1.8);
        double bmi = bmiCounter.countBMI();
        assertEquals(Color.BLUE, bmiCounter.getColorInt());

    }

    @Test
    public void for_less_than_normal_bmi_should_return_blue_color_imperial() {
        BMI bmiCounter = new BmiForImperial(40, 70);
        double bmi = bmiCounter.countBMI();
        assertEquals(Color.BLUE, bmiCounter.getColorInt());

    }

    @Test
    public void for_more_than_normal_bmi_should_return_red_color() {
        BMI bmiCounter = new BmiForKg(120, 1.8);
        double bmi = bmiCounter.countBMI();
        assertEquals(Color.RED, bmiCounter.getColorInt());

    }

    @Test
    public void for_more_than_normal_bmi_should_return_red_color_imperial() {
        BMI bmiCounter = new BmiForImperial(220, 70);
        double bmi = bmiCounter.countBMI();
        assertEquals(Color.RED, bmiCounter.getColorInt());

    }
}