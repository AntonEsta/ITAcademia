package ru.academyit.javacore.lesson3.homework.task5;


import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * <p>Курс
 * <a href=https://academyit.ru>АКАДЕМИЯ АЙТИ</a> <br>
 * <em>"Разработка бизнес приложений в среде Java и Spring"</em>
 * </p>
 *
 * <p><b>Урок №3. Тема "Управляющие конструкции: условия и циклы. Функции и алгоритмы."</b></p>
 *
 * <p><b>Домашняя работа.</b><br>
 * <em>Задание №5.</em> Найти среднее арифметическое 10 случайных чисел.
 *
 * @author Эста А.В.
 */
public class AverageSum {

    public static void main(String[] args) {

        final int NUMBER_ARRAY_LENGTH = 10;
        final int MAX_NUMBER_FOR_NUMBER_GENERATOR = 100;


        double[] numbs = new double[NUMBER_ARRAY_LENGTH];

        for (int i = 0; i < NUMBER_ARRAY_LENGTH; i++) {
            numbs[i] = simpleNumberGenerator(MAX_NUMBER_FOR_NUMBER_GENERATOR);
        }

        System.out.println("Данны следующие " + NUMBER_ARRAY_LENGTH + " случайных чисел от 1 до " + MAX_NUMBER_FOR_NUMBER_GENERATOR + ":");
        // вывести сгенерированные числа
        Arrays.stream(numbs).forEach((d) -> System.out.println(new DecimalFormat("0.##").format(d)));

        System.out.println("\nСреднее арифметическое значение: " + new DecimalFormat("0.##").format(avg(numbs)));

    }

    static double simpleNumberGenerator(double max) {
        return Math.random() * (max - 1) + 1;
    }

    static double avg(double... numbs) {
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
