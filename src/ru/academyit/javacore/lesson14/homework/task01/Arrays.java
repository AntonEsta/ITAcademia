package ru.academyit.javacore.lesson14.homework.task01;

import java.util.Objects;

/**
 * Utility class for operations by array.
 */
public class Arrays {

    /**
     * Sorting array by quick sort method.
     *
     * @param array Integer array.
     * @return Sorted integer array.
     */
    public static int[] sort(int[] array) {                             // complexity: (n log n)
        if (Objects.isNull(array) || array.length < 2) return array;    // complexity: O(1)
        // выбираем базовый элемент
        int base;                                                       // complexity: O(1)
        if (array.length > 2) {                                         // complexity: O(1)
            Random rnd = new Random(0, array.length - 1);               // complexity: O(1)
            base = array[rnd.nextInt()];                                // complexity: O(1)
        } else {
            base = array[0];
        }
        // создаем пустые массивы для значений меньше, больше и равных базовому элементу
        int[] lt = new int[]{};                                         // complexity: O(1)
        int[] gt = new int[]{};                                         // complexity: O(1)
        int[] eq = new int[]{};                                         // complexity: O(1)
        // распределяем каждый элемент массива относительно базового элемента
        // for cycle anyway complexity: O(n)
        for (int value : array) {
            if (value < base) {                                         // complexity: O(1)
                lt = append(lt, value);                                 // complexity: O(n)
            }
            if (value > base) {                                         // complexity: O(1)
                gt = append(gt, value);                                 // complexity: O(n)
            }
            if (value == base) {                                        // complexity: O(1)
                eq = append(eq, value);                                 // complexity: O(n)
            }
        }
        // сортируем массивы со значениями выше и ниже базы
        lt = sort(lt);                                                  // complexity: O(n log n)
        gt = sort(gt);                                                  // complexity: O(n log n)
        // собираем 3 массива в один
        return join(lt, eq, gt);                                        // complexity: O(n)
    }

    /**
     * Append value to array.
     *
     * @param array  Source array.
     * @param values New values for appending.
     * @return Appended array.
     */
    public static int[] append(int[] array, int... values) {            // complexity: O(n)
        if (Objects.isNull(array) || values.length == 0) return array;  // complexity: O(1)
        int[] resArr = new int[array.length + values.length];           // complexity: O(1)
        int index = 0;                                                  // complexity: O(1)
        for (int val : array) {                                         // complexity: O(f(n))
            resArr[index++] = val;                                      // complexity: O(1)
        }
        for (int val : values) {                                        // complexity: O(g(n))
            resArr[index++] = val;                                      // complexity: O(1)
        }
        return resArr;                                                  // complexity: O(1)
    }

    /**
     * Joins arrays in one array.
     *
     * @param arrays Arrays for joining.
     * @return Joined array.
     */
    public static int[] join(int[]... arrays) {                 // complexity: O(n)
        int size = 0;
        for (int[] arr : arrays) {                              // complexity: O(f(n)) - ничтожно мало по отношению к след. операциям
            size += arr.length;                                 // complexity: O(1)
        }
        int[] resArr = new int[size];                           // complexity: O(1)
        // фактически мы обходим все значения массивов один раз соответственно сложность: O(n)
        for (int i = arrays.length - 1; i >= 0; i--) {          // complexity: O(g(n))
            for (int j = arrays[i].length - 1; j >= 0; j--) {   // complexity: O(h(n))
                resArr[--size] = arrays[i][j];                  // complexity: O(1)
            }
        }
        return resArr;                                          // complexity: O(1)
    }

}
