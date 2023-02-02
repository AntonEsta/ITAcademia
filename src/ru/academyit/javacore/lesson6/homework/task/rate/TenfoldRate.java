package ru.academyit.javacore.lesson6.homework.task.rate;

/**
 * Класс десятикратной ставки
 */
public class TenfoldRate extends Rate {

    @Override
    public Double getRate() {
        return getSalary() * 10;
    }

}
