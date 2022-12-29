package ru.academyit.javacore.lesson2.homework.task1.discounts;

import ru.academyit.javacore.lesson2.homework.task1.product.Product;

/**
 * Класс скидки на товар на указанный процент.
 */
public class PercentageOfTheCostOfTheProductDiscount implements Discounter {
    private final int percent;
    private final String description;

    public PercentageOfTheCostOfTheProductDiscount(int percent, String description) {
        this.description = description;
        if (percent > 0 && percent <= 100) {
            this.percent = percent;
        } else if (percent > 100) {
            this.percent = 100;
        } else {
            this.percent = 0;
        }
    }

    /**
     * Возвращает стоимость скидки на товар.
     *
     * @param product товар для скидки
     * @return стоимость скидки
     */
    @Override
    public double getDiscountCost(Product product) {
        return product.getCost() * this.percent / 100;
    }

    /**
     * Определяет применима ли данная скидка для указанного товара
     *
     * @param product товар для предоставления скидки.
     * @return {@code true} если скидка может быть применена для данного товара.
     */
    @Override
    public boolean isApply(Product product) {
        return true;
    }

    /**
     * Применяет скидку к указанному товару.
     *
     * @param product товар для скидки.
     * @return товар с примененной скидкой.
     */
    @Override
    public Product apply(Product product) {
        Product clone = product.clone();
        clone.setCost(product.getCost() - product.getCost() * this.percent / 100);
        return clone;
    }

    @Override
    public String toString() {
        return this.description + "составляет " + percent + "%";
    }
}
