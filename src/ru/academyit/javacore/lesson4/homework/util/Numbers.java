package ru.academyit.javacore.lesson4.homework.util;

public final class Numbers {

    public static double simpleNumberGenerator(double min, double max) {
        if (!Double.isFinite(min) || !Double.isFinite(max)) {
            return 0;
        }

        var minOfRange = Math.min(min, max);
        var maxOfRange = Math.max(min, max);

        return Math.random() * (maxOfRange - minOfRange) + minOfRange;
    }

    public static double average(double... numbs) {
        double res = 0;
        if (numbs.length > 0) {
            for (double n : numbs) {
                res += n;
            }
            res /= numbs.length;
        }
        return res;
    }

    public static double average(int... numbs) {
        double res = 0;
        if (numbs.length > 0) {
            for (double n : numbs) {
                res += n;
            }
            res /= numbs.length;
        }
        return res;
    }

}
