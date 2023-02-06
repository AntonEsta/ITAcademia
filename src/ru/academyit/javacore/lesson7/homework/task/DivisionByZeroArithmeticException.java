package ru.academyit.javacore.lesson7.homework.task;

/**
 *
 */
public class DivisionByZeroArithmeticException extends ArithmeticException {


    public DivisionByZeroArithmeticException() {
        super("Illegal division by zero.");
    }

    public DivisionByZeroArithmeticException(String s) {
        super(s);
    }
}
