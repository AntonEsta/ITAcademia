package ru.academyit.javacore.lesson2.homework.task1;

import ru.academyit.javacore.lesson2.homework.task1.product.Product;

public class PercentageOfTheCostOfTheProductDiscount implements Discount {
    private final int percent;

    public PercentageOfTheCostOfTheProductDiscount(int percent) {
        if (percent >  0 && percent <= 100) {
            this.percent = percent;
        } else if (percent > 100) {
            this.percent = 100;
        } else {
            this.percent = 0;
        }
    }

    @Override
    public Product apply(Product product) {
        Product clone = product.clone();
        clone.setCost(product.getCost() * this.percent / 100);
        return clone;
    }

}
