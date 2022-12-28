package ru.academyit.javacore.lesson2.homework.task1.discounts;

public abstract class AbstractDiscount implements Discounter {

    protected String description;

    protected AbstractDiscount(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public abstract boolean isApply(Product product);
//
//    public abstract Product apply(Product product);

}
