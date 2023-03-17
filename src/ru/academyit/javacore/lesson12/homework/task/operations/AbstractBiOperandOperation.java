package ru.academyit.javacore.lesson12.homework.task.operations;

public abstract class AbstractBiOperandOperation implements Operation {
    Double num1, num2;

    public AbstractBiOperandOperation(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public abstract Double execute();
}
