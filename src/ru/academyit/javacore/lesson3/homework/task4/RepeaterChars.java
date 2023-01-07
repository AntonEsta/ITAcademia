package ru.academyit.javacore.lesson3.homework.task4;


/**
 * <p>Курс
 * <a href=https://academyit.ru>АКАДЕМИЯ АЙТИ</a> <br>
 * <em>"Разработка бизнес приложений в среде Java и Spring"</em>
 * </p>
 *
 * <p><b>Урок №3. Тема "Управляющие конструкции: условия и циклы. Функции и алгоритмы."</b></p>
 *
 * <p><b>Домашняя работа.</b><br>
 * <em>Задание №4.</em> Вывести в консоль 20 строк вида, используя цикл
 * <br>#
 * <br>##
 * <br>###
 * <br>####
 * <br>#####
 * <br>######</p>
 *
 * @author Эста А.В.
 */
public class RepeaterChars {

    public static void main(String[] args) {

        final char CHAR = '#';      // символ для заполнения строки
        final int LINES_COUNT = 20; // количество строк которое нужно вывести

        for (int i = 0; i < LINES_COUNT; i++) {
            printLinesOfChar(CHAR, i + 1);
        }

    }

    /**
     * Выводит строки состоящие из указанного символа.
     *
     * @param ch    символ для наполнения строки.
     * @param count количество повторений символов.
     */
    static void printLinesOfChar(char ch, int count) {
        if (count <= 0) {
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

}
