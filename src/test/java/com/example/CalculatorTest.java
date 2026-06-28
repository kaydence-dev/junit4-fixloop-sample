package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * JUnit 4 tests with CLEAN, alphabetically-ordered imports (checkstyle-green on
 * main). The 4->5 migration converts @Before/@BeforeClass/@After/@Test and the
 * org.junit.Assert statics — inserting org.junit.jupiter.api.* imports whose
 * order (e.g. BeforeEach vs BeforeAll) no longer satisfies the alphabetical
 * ImportOrder rule, so CI's checkstyle goes red while `mvn test` stays green.
 */
public class CalculatorTest {

    private Calculator calc;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("starting CalculatorTest");
    }

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @After
    public void tearDown() {
        calc = null;
    }

    @Test
    public void add() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    public void subtract() {
        assertEquals(1, calc.subtract(3, 2));
    }

    @Test
    public void multiplyAndDivide() {
        assertEquals(6, calc.multiply(2, 3));
        assertTrue(calc.divide(4, 2) == 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideByZeroThrows() {
        calc.divide(1, 0);
    }
}
