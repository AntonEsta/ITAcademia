package ru.academyit.javacore.lesson2.homework.task1.discounts;

import ru.academyit.javacore.lesson2.homework.task1.product.Product;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Класс скидки предоставляемой в выходные дни.
 */
public class WeekendDiscount implements Discounter {

    private final Discounter discount;
    private final String description;

    public WeekendDiscount(Discounter discount, String description) {
        this.description = description;
        this.discount = discount;
    }

    /**
     * Возвращает стоимость скидки.
     *
     * @param product товар для скидки.
     * @return стоимость скидки.
     */
    @Override
    public double getDiscountCost(Product product) {
        return this.discount.getDiscountCost(product);
    }

    /**
     * Показывает применима ли скидка для товара.
     *
     * @param product товар-претендент на скидку
     * @return {@code true} если скидка может быть применена.
     */
    @Override
    public boolean isApply(Product product) {
        DayOfWeek dayOfWeek = DayOfWeek.of(LocalDate.now().getDayOfWeek().getValue());
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    /**
     * Применяет скидку к указанному товару.
     *
     * @param product товар для скидки.
     * @return товар с примененной скидкой.
     */
    @Override
    public Product apply(Product product) {
        if (isApply(product)) {
            return discount.apply(product);
        } else {
            return product.clone();
        }
    }

    @Override
    public String toString() {
        return description;
    }

}
