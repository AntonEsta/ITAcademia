package ru.academyit.javacore.lesson3.homework.task1;


/**
 * <p>Курс
 * <a href=https://academyit.ru>АКАДЕМИЯ АЙТИ</a> <br>
 * <em>"Разработка бизнес приложений в среде Java и Spring"</em>
 * </p>
 *
 * <p><b>Урок №3. Тема "Управляющие конструкции: условия и циклы. Функции и алгоритмы."</b></p>
 *
 * <p><b>Домашняя работа.</b><br>
 * <em>Задание №1.</em> Вывести все простые числа от 2 до 100.</p>
 *
 * @author Эста А.В.
 */
public class PrimeNumber {

    public static void main(String[] args) {

        final int START_NUMBER = 2;
        final int END_NUMBER = 100;

        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i);
            }
        }

    }


}
