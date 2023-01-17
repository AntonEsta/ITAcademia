package ru.academyit.javacore.lesson4.homework.task3;

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
 * <em>Задание №3.</em> Перевернуть массив, который содержит названия цветов радуги.
 *     То есть первый элемент должен стать последним второй – предпоследним.
 *
 * @author Эста А.В.
 */
public class ArrayInvertSample {

    public static void main(String[] args) {
        final String[] colorsRainbows = {"красный", "оранжевый", "жёлтый", "зелёный", "голубой", "синий", "фиолетовый"};
        System.out.println("Исходный массив:\t\t" + Arrays.toString(colorsRainbows));
        System.out.println("Инвертированный массив:\t" + Arrays.toString(invertArray(colorsRainbows)));
    }

    /**
     * Возвращает полученный массив в обратном порядке.
     *
     * @param arr исходный массив
     * @return массив с элементами в обратном порядке
     */
    static String[] invertArray(String[] arr) {
        String[] resArray = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            resArray[i] = arr[arr.length - 1 - i];
        }
        return resArray;
    }

}
