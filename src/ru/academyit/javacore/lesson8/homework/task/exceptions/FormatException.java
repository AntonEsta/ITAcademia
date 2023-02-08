package ru.academyit.javacore.lesson8.homework.task.exceptions;

public class FormatException extends IllegalArgumentException {
    public FormatException(String s) {
        super(s);
    }
}
