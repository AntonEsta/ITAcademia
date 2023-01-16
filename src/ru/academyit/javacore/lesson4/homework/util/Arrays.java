package ru.academyit.javacore.lesson4.homework.util;

import java.util.Objects;

public final class Arrays {

    /**
     * Возвращает полученный массив в обратном порядке.
     * @param arr исходный массив
     * @return массив с элементами в обратном порядке
     */
    public static Object[] invertArray(Object[] arr) {
        Object[] resArray = new Object[arr.length];
        for (int i=0; i < arr.length; i++) {
            resArray[i] = arr[arr.length-1-i];
        }
        return resArray;
    }



}
