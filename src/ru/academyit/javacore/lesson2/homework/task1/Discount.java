package ru.academyit.javacore.lesson2.homework.task1;

import ru.academyit.javacore.lesson2.homework.task1.product.Product;

public interface Discount {

    Product apply(Product product);

}
