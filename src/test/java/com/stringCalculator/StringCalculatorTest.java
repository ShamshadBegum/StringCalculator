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

    @Test
    public void numberOfString(){
        assertEquals(2, StringCalculator.add("1000,2"));
    }

    @Test
    public void newLinesBetweenNumbers(){
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void delimiterString(){
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void negativesNotAllowed(){
        try{
            StringCalculator.add("-1,2");
        }catch(IllegalArgumentException illegalArgumentException){
            assertEquals(illegalArgumentException.getMessage(), "Negatives not allowed: -1");
        }

        try{
            StringCalculator.add("2,-4,3,-5");
        }catch(IllegalArgumentException illegalArgumentException){
            assertEquals(illegalArgumentException.getMessage(), "Negatives not allowed: -4,-5");
        }
    }

    @Test
    public void moreThanThousandShouldIgnore(){
        assertEquals(2, StringCalculator.add("2,1001"));
    }
}
