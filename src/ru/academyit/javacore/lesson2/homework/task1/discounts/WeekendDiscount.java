package ru.academyit.javacore.lesson2.homework.task1.discounts;

import jdk.jfr.Frequency;
import ru.academyit.javacore.lesson2.homework.task1.product.Product;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendDiscount implements Discounter {

    private final Discounter discount;
    private final String description;

    public WeekendDiscount(Discounter discount, String description) {
        this.description = description;
        this.discount = discount;
    }

    @Override
    public boolean isApply(Product product) {
        DayOfWeek dayOfWeek = DayOfWeek.of(LocalDate.now().getDayOfWeek().getValue());
        return true; // dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    @Override
    public Product apply(Product product) {
        if ( isApply(product) ) {
            return discount.apply(product);
        } else {
            return product.clone();
        }
    }

    @Override
    public String toString() {
        return description;
    }

}
