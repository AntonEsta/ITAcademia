package ru.academyit.javacore.lesson12.homework.task.operations;

public class DivideOperation extends AbstractBiOperandOperation {

    public DivideOperation(double num1, double num2) {
        super(num1, num2);
    }

    @Override
    public Double execute() {
        return num1 / num2;
    }

}
