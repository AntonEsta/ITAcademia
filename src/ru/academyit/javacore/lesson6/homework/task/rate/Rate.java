package ru.academyit.javacore.lesson6.homework.task.rate;

import static ru.academyit.javacore.lesson6.homework.task.Main.mainProperties;

/**
 * Абстрактный класс ставки.
 */
public abstract class Rate {

    /**
     * Базовая ставка оплаты труда сотрудника
     *
     * @return значение базовой ставки
     */
    public static Double getSalary() {
        return Double.parseDouble(mainProperties.getPropertyOrDefault("Base Salary", "0.0"));
    }

    /**
     * Абстрактный метод получения ставки
     *
     * @return ставка
     */
    public abstract Double getRate();

    @Override
    public String toString() {
        return "FourfoldRate{salary= " + getSalary() + ", rate= " + getRate() + "}";
    }

}
