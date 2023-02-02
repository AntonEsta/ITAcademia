package ru.academyit.javacore.lesson6.homework.task;

import ru.academyit.javacore.lesson6.homework.task.rate.Rate;

/**
 * Класс должности сотрудника
 */
public class Position {

    private String title;   // наименование должности
    private Rate rate;      // тариф

    public Position(String title, Rate rate) {
        this.title = title;
        this.rate = rate;
    }

    // Getters & Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    // Overrides

    @Override
    public String toString() {
        return "Position{" +
                "position='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position1 = (Position) o;

        return title.equals(position1.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

}
