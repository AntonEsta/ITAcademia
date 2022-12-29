package ru.academyit.javacore.lesson2.homework.task1.cash;

import ru.academyit.javacore.lesson2.homework.task1.product.Product;

/**
 *  Класс позиции в чеке.
 */
public class Position {

    private Product product; // товар
    private double quantity; // количество отпущенного товара

    public Position(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Устанавливает количество товара
     * @param quantity - количество товара
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * Предоставляет количество товара
     * @return количество товара
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Возвращает товар позиции
     * @return товар
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Получает товар
     * @param product товар
     */
    public void setProduct(Product product) {
        this.product = product;
    }
}
