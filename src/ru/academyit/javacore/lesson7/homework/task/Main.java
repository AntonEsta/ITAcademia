package ru.academyit.javacore.lesson7.homework.task;

import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        final int[] intArray1 = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 10};
        final int[] intArray2 = new int[]{1, 2, 3, 0, 5, 6, 7, 8, 9, 0};

        double[] intResultArray = dividingArrayByArray(intArray1, intArray2);

        // контроль результата
        assert Arrays.equals(intResultArray,
                new double[]{2, 2, 2, Double.NaN, 2, 2, 2, 2, 2, Double.NaN}) : "Массив считается не верно. " + Arrays.toString(intResultArray) + " не равен [2, 2, 2, NaN, 2, 2, 2, 2, 2, NaN]";

        System.out.println(Arrays.toString(intResultArray));

    }

    /**
     * Делит попарно значения первого массива на значения второго массива.
     * Размерность массивов a и b должны быть одного размера.
     *
     * @param a Массив целых чисел значения которого необходимо поделить.
     * @param b Массив целых чисел на значения которого необходимо поделить.
     * @return Массив результатов делений
     */
    public static double[] dividingArrayByArray(int[] a, int[] b) {

        if (Objects.isNull(a) || Objects.isNull(b)) {
            throw new NullPointerException("Один из переданных параметров равен null.");
        }

        if (a.length != b.length) {
            throw new IllegalArgumentException("Предоставленные массивы различного размера! Метод работает только с массивами одинакового размера.");
        }

        double[] resultArr = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            try {
                resultArr[i] = a[i] / b[i];
            } catch (ArithmeticException e) {
                resultArr[i] = Double.NaN;
            }
        }
        return resultArr;
    }

}