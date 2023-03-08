package ru.academyit.javacore.lesson13.homework.task01;

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
        int base = array[0];                                            // complexity: O(1)
        if (array.length > 2) {                                         // complexity: O(1)
            Random rnd = new Random(0, array.length - 1);               // complexity: O(1)
            base = array[rnd.nextInt()];                                // complexity: O(1)
        }
        int[] lt = new int[]{};                                         // complexity: O(1)
        int[] gt = new int[]{};                                         // complexity: O(1)
        int[] eq = new int[]{};                                         // complexity: O(1)

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

        // recurs
        lt = sort(lt);                                                  // complexity: O(n log n)
        gt = sort(gt);                                                  // complexity: O(n log n)
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
        for (int[] arr : arrays) {                              // complexity: O(f(n)) - ничьтожно мало по отношению к след. операциям
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

//    /**
//     * Compare two array whether they are identical in their contained values.
//     *
//     * @param arrayOne First array for compare.
//     * @param arrayTwo Second array for compare.
//     * @return Returns {@code true} if both arrays is identical and {@code false}
//     * if is not.
//     */
//    public static boolean equals(int[] arrayOne, int[] arrayTwo) {
//        if (arrayOne.length != arrayTwo.length) return false;
//        if (arrayOne == arrayTwo) return true;
//        for (int i = 0; i < arrayOne.length; i++) {
//            if (arrayOne[i] != arrayTwo[i]) return false;
//        }
//        return true;
//    }

//    /**
//     * Returns integer array like {@link String}
//     *
//     * @param array Integer array for transformation.
//     * @return Array like {@link String}
//     */
//    public static String toString(int[] array) {
//        String str = "{";
//        for (int i = 0; i < array.length; i++) {
//            str = str.concat(String.valueOf(array[i]));
//            if (i < array.length - 1) {
//                str += ",";
//            }
//        }
//        str += "}";
//        return str;
//    }

}
