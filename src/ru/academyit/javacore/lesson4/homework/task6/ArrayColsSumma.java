package ru.academyit.javacore.lesson4.homework.task6;

import java.util.Arrays;
import java.util.Objects;

import static ru.academyit.javacore.lesson4.homework.task4.PythagoreanTable.createPythagoreanTable;

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
        int[][] sourceTable = createPythagoreanTable(ARRAY_SIZE);
        int[][] table = addRowArray(sourceTable, sumArrayByColumns(sourceTable)); // генерировать массив
        // Вывести результат в виде матрицы
        for (int[] i : table) {
            for (int j : i) {
                System.out.print(j + "\t\t");
            }
            System.out.println();
        }
    }

    /**
     * Дополняет матрицу строкой.
     *
     * @param a исходный двумерный массив.
     * @return массив нового размера.
     */
    static int[][] addRowArray(int[][] a, int[] b) {
        if (Objects.isNull(a) || a[0].length == 0) {
            return new int[0][0];
        }
        if (a[0].length != b.length) {
            throw new IndexOutOfBoundsException("Размеры массивов не совпадают. Копирование не возможно.");
        }
        int[][] t = Arrays.copyOf(a, a.length + 1);       // создать новый массив с +1 строкой
        t[t.length - 1] = new int[t[0].length];                     // инициализация последней строки матрицы
        System.arraycopy(b, 0, t[t.length - 1], 0, t[0].length);
        return t;
    }

    /**
     * Находит сумму целых чисел массива.
     *
     * @param a входной массив.
     * @return сумма всех элементов массива.
     */
    static int sum(int[] a) {
        if (Objects.isNull(a)) {
            return 0;
        }
        int i = 0;
        for (int j : a) {
            i += j;
        }
        return i;
    }

    /**
     * Рассчитывает суммы по столбцам и возвращает их массивом.
     *
     * @param a исходная матрица.
     * @return массив сумм по столбцам матрицы.
     */
    static int[] sumArrayByColumns(int[][] a) {
        if (Objects.isNull(a) || a.length == 0) {
            return new int[0];
        }
        int[] s = new int[a[0].length];
        for (int j = 0; j < a[0].length; j++) {
            int[] c = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                if (Objects.nonNull(a[i])) {
                    c[i] = a[i][j];
                } else {
                    c[i] = 0;
                }
            }
            s[j] = sum(c);
        }
        return s;
    }

}
