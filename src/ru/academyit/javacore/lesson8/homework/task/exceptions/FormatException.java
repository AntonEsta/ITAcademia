package ru.academyit.javacore.lesson8.homework.task.exceptions;

/**
 * Класс исключения для не верного формата данных.
 */
public class FormatException extends IllegalArgumentException {
    public FormatException(String s) {
        super(s);
    }
}
