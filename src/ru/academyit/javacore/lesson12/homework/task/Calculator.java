package ru.academyit.javacore.lesson12.homework.task;

import ru.academyit.javacore.lesson12.homework.task.operations.Operation;

public class Calculator {

//    private static final Double result = null;
    private static Operation operation = null;

//    public Double getResult() {
//        return result;
//    }

//    public Operation getOperation() {
//        return operation;
//    }

    public static void setOperation(Operation operation) {
        Calculator.operation = operation;
    }

    public static Double calculate() {
        if (operation == null) {
            return null;
        }
        return operation.execute();
    }

}
