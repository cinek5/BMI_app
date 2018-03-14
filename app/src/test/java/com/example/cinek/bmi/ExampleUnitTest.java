package com.example.cinek.bmi;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void for_valid_mass_and_height_should_return_correct_value() {
        BMI bmiCounter = new BmiForKg(60, 1.7);
        double bmi = bmiCounter.countBMI();
        assertEquals(20.761, bmi, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void for_zero_mass_and_height_should_throw_exception() {
        BMI bmiCounter = new BmiForKg(0, 0);
        double bmi = bmiCounter.countBMI();
        assertEquals(20.761, bmi, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void for_minus_mass_and_height_should_throw_exception() {
        BMI bmiCounter = new BmiForKg(-1, -1);
        double bmi = bmiCounter.countBMI();
        assertEquals(20.761, bmi, 0.001);
    }
}