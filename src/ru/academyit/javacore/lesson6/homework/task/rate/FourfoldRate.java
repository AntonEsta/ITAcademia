package ru.academyit.javacore.lesson6.homework.task.rate;

/**
 * Класс четырёхкратной ставки
 */
public class FourfoldRate extends Rate {

    @Override
    public Double getRate() {
        return getSalary() * 4;
    }

}
