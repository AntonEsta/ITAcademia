package ru.academyit.javacore.lesson6.homework.task.rate;

/**
 * Класс двухкратной ставки
 */
public class DoubleRate extends Rate {

    @Override
    public Double getRate() {
        return getSalary() * 2;
    }

}
