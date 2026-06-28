package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit 4 tests with CLEAN, alphabetically-ordered imports (checkstyle-green on
 * main). The 4->5 migration converts @Before/@BeforeClass/@After/@Test and the
 * org.junit.Assert statics — inserting org.junit.jupiter.api.* imports whose
 * order (e.g. BeforeEach vs BeforeAll) no longer satisfies the alphabetical
 * ImportOrder rule, so CI's checkstyle goes red while `mvn test` stays green.
 */
class CalculatorTest {

    private Calculator calc;

    @BeforeAll
    protected static void setUpClass() {
        System.out.println("starting CalculatorTest");
    }

    @BeforeEach
    protected void setUp() {
        calc = new Calculator();
    }

    @AfterEach
    protected void tearDown() {
        calc = null;
    }

    @Test
    protected void add() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    protected void subtract() {
        assertEquals(1, calc.subtract(3, 2));
    }

    @Test
    protected void multiplyAndDivide() {
        assertEquals(6, calc.multiply(2, 3));
        assertTrue(calc.divide(4, 2) == 2);
    }

    @Test
    protected void divideByZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(1, 0));
    }
}
