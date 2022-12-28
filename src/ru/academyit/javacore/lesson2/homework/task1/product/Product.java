package ru.academyit.javacore.lesson2.homework.task1.product;

public class Product implements Cloneable{

    private String name;
    private double cost;

    public double getCost() {
        return cost;
    }

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    @Override
    public Product clone() {
        try {
            Product clone = (Product) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
