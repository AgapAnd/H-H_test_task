package ru.agapov.validator;

public class Validator {
    public static boolean arrayIsValid(int[] array) {
        if (array.length != 3) {
            System.out.println("Invalid values, enter values like this: '10 10 5' for example");
            return false;
        }
        if (array[0] < 1 || array[0] > 30 || array[1] < 1 || array[1] > 30
                || array[2] < 1 || array[2] > 6) {
            System.out.println("Invalid values, it should be in this interval: '1-30 1-30 1-6' ");
            return false;
        }
        return true;
    }
}
