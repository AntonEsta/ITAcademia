package ru.academyit.javacore.lesson4.homework.task2;


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
 * <em>Задание №2.</em> Вывести массив, состоящий из цветов радуги в обратном порядке.
 *
 * @author Эста А.В.
 */
public class PrintArrayInvert {

    public static void main(String[] args) {

        final String[] colorsRainbows = {"красный", "оранжевый", "жёлтый", "зелёный", "голубой", "синий", "фиолетовый"};

        System.out.println("Исходный массив:\t\t\t" + Arrays.toString(colorsRainbows));
        System.out.print("Вывод в обратном порядке:\t[");
        for (int i = colorsRainbows.length-1; i >= 0; i--) {
            System.out.print(colorsRainbows[i]);
            if (i != 0) {
                System.out.print(", ");
            } else {
                System.out.println("]");
            }
        }

    }

}
