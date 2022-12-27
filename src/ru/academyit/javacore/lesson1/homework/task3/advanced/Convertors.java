package ru.academyit.javacore.lesson1.homework.task3.advanced;

/**
 * Класс с методами конвертации величин
 */
public final class Convertors {

    /**
     * Конвертирует метры в километры.
     *
     * @param meters расстояние в метрах
     * @return Расстояние в полных километрах
     */
    public static long toKilometers(long meters) {
        return meters / 1000;
    }

    /**
     * Конвертирует метры в километры.
     *
     * @param meters расстояние в метрах
     * @return Расстояние в полных километрах
     */
    public static long toKilometers(double meters) {
        return (long) meters / 1000;
    }

}
