package ru.academyit.javacore.lesson2.homework.task1.discounts;

import ru.academyit.javacore.lesson2.homework.task1.product.Product;

public interface Discounter {

    boolean isApply(Product product);
    Product apply(Product product);

}
