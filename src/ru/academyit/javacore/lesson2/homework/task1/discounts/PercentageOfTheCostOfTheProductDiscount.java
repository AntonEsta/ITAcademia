package ru.academyit.javacore.lesson2.homework.task1.discounts;

import ru.academyit.javacore.lesson2.homework.task1.product.Product;

public class PercentageOfTheCostOfTheProductDiscount implements Discounter {
    private final int percent;
    private final String description;

    public PercentageOfTheCostOfTheProductDiscount(int percent, String description) {
        this.description = description;
        if (percent >  0 && percent <= 100) {
            this.percent = percent;
        } else if (percent > 100) {
            this.percent = 100;
        } else {
            this.percent = 0;
        }
    }

    @Override
    public boolean isApply(Product product) {
        return true;
    }

    @Override
    public Product apply(Product product) {
        Product clone = product.clone();
        clone.setCost(product.getCost() * this.percent / 100);
        return clone;
    }

    @Override
    public String toString() {
        return this.description + "составляет " + percent + "%";
    }
}
