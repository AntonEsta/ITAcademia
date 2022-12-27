package ru.academyit.javacore.lesson2.homework.task1.product;

public class Product {

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
}
