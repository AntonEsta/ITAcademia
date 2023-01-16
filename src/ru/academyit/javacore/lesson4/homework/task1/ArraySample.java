package ru.academyit.javacore.lesson4.homework.task1;


import java.util.Arrays;

/**
 * <p>Курс
 * <a href=https://academyit.ru>АКАДЕМИЯ АЙТИ</a> <br>
 * <em>"Разработка бизнес приложений в среде Java и Spring"</em>
 * </p>
 *
 * <p><b>Урок №4. Тема "Основы ООП."</b></p>
 *
 * <p><b>Домашняя работа.</b><br>
 * <em>Задание №1.</em> Создать метод, который создает и возвращает массив случайных целых чисел.
 * Найти среднее арифметическое полученного массива.
 * Можно среднее арифметическое в теле метода main.
 *
 * @author Эста А.В.
 */
public class ArraySample {

    public static void main(String[] args) {

        final int ARRAY_SIZE = 10;
        final int RANDOM_MIN = -200;
        final int RANDOM_MAX = 432;

        int[] randomIntArray = getRandomIntArray(ARRAY_SIZE, RANDOM_MIN, RANDOM_MAX);

        System.out.println("Сгенерирован массив из " + ARRAY_SIZE + " элемента(ов) : " + Arrays.toString(randomIntArray));
        System.out.println("Среднее значение массива составляет: " + average(randomIntArray));

    }


    /**
     * Создаёт и возвращает массив случайных целых чисел.
     * @param size размерность массива.
     * @param min минимальное значение генерируемого числа.
     * @param max максимальное значение генерируемого числа.
     * @return массив случайных целых чисел.
     *
     * Если размер массива {@code size} указан нулевой или отрицательный, то возвращается пустой массив.
     * Границы генератора чисел можно указывать в любом порядке.
     */
    static int[] getRandomIntArray(int size, double min, double max) {

        if (size <= 0) {
            return new int[0];
        }

        int[] resArray = new int[size];

        for (int i = 0; i < size; i++) {
            resArray[i] = (int) simpleNumberGenerator(min, max);
        }

        return resArray;

    }


    /**
     * Простой генератор случайных чисел.
     * @param min минимальное значение генерируемого числа.
     * @param max максимальное значение генерируемого числа.
     * @return сгенерированное случайное число.
     */
    static double simpleNumberGenerator(double min, double max) {
        if (!Double.isFinite(min) || !Double.isFinite(max)) {
            return 0;
        }

        var minOfRange = Math.min(min, max);
        var maxOfRange = Math.max(min, max);

        return Math.random() * (maxOfRange - minOfRange) + minOfRange;
    }

    /**
     * Рассчитывает среднее арифметическое значение ряда чисел.
     * @param numbs ряд чисел для расчета.
     * @return среднее арифметическое значение.
     */
    static double average(int... numbs) {
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
