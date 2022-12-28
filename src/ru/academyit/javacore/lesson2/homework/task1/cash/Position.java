package ru.academyit.javacore.lesson2.homework.task1.cash;

import ru.academyit.javacore.lesson2.homework.task1.product.Product;

public class Position {

    private Product product;
    private double quantity;

    public Position(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
