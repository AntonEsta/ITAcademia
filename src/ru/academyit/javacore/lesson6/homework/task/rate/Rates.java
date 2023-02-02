package ru.academyit.javacore.lesson6.homework.task.rate;

import java.util.function.Function;

public final class Rates {

    /**
     * Возвращает класс Rate индексацией ставки.
     *
     * @param index значение индекса для расчета.
     * @return объект класса Rate.
     */
    public static Rate getRateWithIndex(double index) {
        return new Rate() {
            @Override
            public Double getRate() {
                return getSalary() * index;
            }
        };
    }

    /**
     * Возвращает класс Rate с произвольным методом расчета ставки
     *
     * @param function функция расчета ставки
     * @return объект класса Rate.
     */
    public static Rate getSpecifiedRate(Function<Double, Double> function) {
        return new Rate() {
            @Override
            public Double getRate() {
                return function.apply(getSalary());
            }
        };
    }

}
