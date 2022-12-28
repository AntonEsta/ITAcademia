package ru.academyit.javacore.lesson2.homework.task1.discounts;

import ru.academyit.javacore.lesson2.homework.task1.product.Product;

public class Discount extends AbstractDiscount {


    protected Discount(String description) {
        super(description);
    }

    @Override
    public boolean isApply(Product product) {
        return false;
    }

    @Override
    public Product apply(Product product) {
        return null;
    }
}
