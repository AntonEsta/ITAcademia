package ru.academyit.javacore.lesson4.homework.util;

import java.util.Arrays;

/**
 *
 */
public final class ArrayCreator {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(getRandomIntArray(10, 0, Double.NaN)));
//        System.out.println();
//        int counter1 = 0, counter2 = 0;
//        for (int i = 0; i < 1_000; i++) {
//            int[] array = getRandomIntArray(10, 0, 10);
//            if (Arrays.stream(array).anyMatch(x -> x == 10)) {
//                System.out.println("Обнаружено число 10 на " + (i+1) + " шаге.");
//                counter1++;
//            }
//            if (Arrays.stream(array).anyMatch(x -> x == 0)) {
//                System.out.println("Обнаружено число 0 на " + (i+1) + " шаге.");
//                counter2++;
//            }
//        }
//        System.out.println("Статистика:");
//        System.out.println("Обнаружено число 10: " + counter1);
//        System.out.println("Обнаружено число 0: " + counter2);
    }

    public static int[] getRandomIntArray(int size, double min, double max) {

        if (size <= 0) {
            return new int[0];
        }

        int[] resArray = new int[size];

        for (int i = 0; i < size; i++) {
            resArray[i] = (int) Numbers.simpleNumberGenerator(min, max);
        }

        return resArray;

    }

}
