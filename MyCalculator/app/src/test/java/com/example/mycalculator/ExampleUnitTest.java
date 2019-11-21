package com.example.mycalculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testCalculator() {

        calculatorListener listener = new MockCalculatorListener();
        simpleCalculator calc = new SimpleCalculator(listener);

        calc.setOperand(5)
    }
}