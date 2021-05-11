package com.stringCalculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("com.stringCalculator.StringCalculatorTest");
    }

    @Test
    public void emptyString() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void oneString() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void twoString() {
        assertEquals(3, StringCalculator.add("1,2"));
    }
}
