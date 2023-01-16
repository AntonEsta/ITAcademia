package ru.academyit.javacore.lesson4.homework.task4;

/**
 * <p>Курс
 * <a href=https://academyit.ru>АКАДЕМИЯ АЙТИ</a> <br>
 * <em>"Разработка бизнес приложений в среде Java и Spring"</em>
 * </p>
 *
 * <p><b>Урок №4. Тема "Основы ООП."</b></p>
 *
 * <p><b>Домашняя работа.</b><br>
 * <em>Задание №4.</em> Вывести матрицу, изображенную ниже в консоль.
 * <pre>
 * 0   0   0   0   0
 * 0   1   2   3   4
 * 0   2   4   6   8
 * 0   3   6   9   12
 * 0   4   8   12  16</pre>
 *
 * @author Эста А.В.
 */
public class PythagoreanTable {

    public static void main(String[] args) {

        final int TABLE_SIZE = 5;

        int[][] table = createPythagoreanTable(TABLE_SIZE);

        // Вывести результат в виде матрицы
        for (int[] i : table) {
            for (int j : i) {
                System.out.print(j + "\t\t");
            }
            System.out.println();
        }

    }

    /**
     * Рассчитывает и возвращает таблицу Пифагора в виде матрицы.
     * @param size размер матрицы.
     * @return таблица Пифагора.
     */
    public static int[][] createPythagoreanTable(int size) {
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


}
