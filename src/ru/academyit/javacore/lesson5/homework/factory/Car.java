package ru.academyit.javacore.lesson5.homework.factory;

import java.util.Objects;

/**
 * Класс описания машины
 */
public class Car {
    private String title;
    private int price;

    public Car(String title, int price) {
        if (Objects.isNull(title) || title.isBlank()) {
            throw new IllegalArgumentException("Наименование машины не может быть пустым.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }

        this.title = title;
        this.price = price;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        validateTitle(title);
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        validatePrice(price);
        this.price = price;
    }

    private void validateTitle(String title) {
        if (Objects.isNull(title) || title.isBlank()) {
            throw new IllegalArgumentException("Наименование машины не может быть пустым.");
        }
    }

    private void validatePrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
    }

}
