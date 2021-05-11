package com.stringCalculator;

public class StringCalculator {
    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            String separator = ",";
            if (numbers.matches("//(.*)\n(.*)")) {
                separator = Character.toString(numbers.charAt(2));
                numbers = numbers.substring(4);
            }
            String[] numberList = splitNumbers(numbers, separator + "|\n");
            return sum(numberList);
        }
    }

    private static String[] splitNumbers(String numbers, String divider) {
        return numbers.split(divider);
    }

    private static int toInt(String number) {
        return Integer.parseInt(number);
    }

    private static int sum(String[] allNumbers) {
        int total = 0;
        StringBuilder negativeString = new StringBuilder();

        for (String number : allNumbers) {
            if (toInt(number) < 0) {
                if (negativeString.toString().equals(""))
                    negativeString = new StringBuilder(number);
                else
                    negativeString.append(",").append(number);
            }
            if (toInt(number) < 1000)
                total += toInt(number);
        }

        if (!negativeString.toString().equals("")) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeString);
        }

        return total;
    }
}
