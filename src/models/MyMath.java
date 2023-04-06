package models;

public abstract class MyMath {
    public static boolean isBetween(int number, int min, int max) {
        return min <= number && number <= max;
    }
}
