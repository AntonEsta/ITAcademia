package ru.academyit.javacore.lesson4.homework.task6;

import ru.academyit.javacore.lesson4.homework.task4.PythagoreanTable;

import java.sql.Array;
import java.util.Arrays;
import java.util.Objects;

/**
 * <p>Курс
 * <a href=https://academyit.ru>АКАДЕМИЯ АЙТИ</a> <br>
 * <em>"Разработка бизнес приложений в среде Java и Spring"</em>
 * </p>
 *
 * <p><b>Урок №4. Тема "Основы ООП."</b></p>
 *
 * <p><b>Домашняя работа.</b><br>
 * <em>Задание №5.</em> Написать программу, которая вычисляет сумму двумерного массива по строкам.
 *
 * @author Эста А.В.
 */
public class ArrayColsSumma {

    public static void main(String[] args) {

        final int ARRAY_SIZE = 5;

        int[][] table = PythagoreanTable.createPythagoreanTable(ARRAY_SIZE); // генерировать массив

        int[][] newTable = Arrays.copyOf(table, table.length+1); // новый массив с +1 строка

        // подсчет и подстановка сумм строк в массив
        for (int i = 0; i < newTable.length; i++) {
            int[] t = new int[newTable.length];
            for (int j = 0; j < newTable[0].length; j++) {
                t[j] = newTable[j][i];
            }
            if (Objects.isNull(newTable[newTable.length-1])) {
                newTable[newTable.length-1] = new int[newTable.length];
            }
            newTable[newTable.length-1][i] = sum(t);
        }

        // Вывести результат в виде матрицы
        for (int[] i : newTable) {
            for (int j : i) {
                System.out.print(j + "\t\t");
            }
            System.out.println();
        }

    }

    /**
     * Копирует оригинальный двумерный массив в новый массив указанного размера.
     *
     * @param original   исходный массив.
     * @param newLength1 новая длина массива
     * @param newLength2 новая длина под массивов массива
     * @return новый массив
     */
    static int[][] copyArray(int[][] original, int newLength1, int newLength2) {
        int[][] newTable = new int[newLength1][newLength2]; // новый массив с +1 столбец
        for (int i = 0; i < newTable.length; i++) {
            System.arraycopy(original[i], 0, newTable[i], 0, newTable.length);
        }
        return newTable;
    }

    /**
     * Рассчитывает и возвращает таблицу Пифагора в виде матрицы.
     *
     * @param size размер матрицы.
     * @return таблица Пифагора.
     */
    static int[][] createPythagoreanTable(int size) {
        if (size < 0) {
            return new int[0][0];
        }
        int[][] resArray = new int[size][size];
        for (int i = 1; i < size; i++) {
            for (int j = i; j < size; j++) {
                int p = i * j;
                resArray[i][j] = p;
                resArray[j][i] = p;
            }
        }
        return resArray;
    }

    /**
     * Находит сумму целых чисел массива.
     *
     * @param array входной массив.
     * @return сумма всех элементов массива.
     */
    static int sum(int[] array) {
        int i = 0;
        for (int j : array) {
            i += j;
        }
        return i;
    }

}
