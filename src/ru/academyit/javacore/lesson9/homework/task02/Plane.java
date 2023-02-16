package ru.academyit.javacore.lesson9.homework.task02;

import java.util.Objects;

public class Plane {

    private final String title;
    private final int number;

    private double fuelLevel;  //уровень топлива в баке

    public Plane(String title, int number, double fuelLevel) {
        this.title = title;
        this.number = number;
        this.fuelLevel = correctLevel(fuelLevel);
    }

    public Plane(String title, int number) {
        this.title = title;
        this.number = number;
        this.fuelLevel = Math.random() * (30 - 15) + 15;
    }

    public String getTitle() {
        return title;
    }

    public int getNumber() {
        return number;
    }

    public double getFuelLevel() {
        return this.fuelLevel;
    }

    /**
     * Корректировка задания уровня топлива
     * @param level устанавливаемый уровень топлива.
     * @return корректный уровень топлива
     */
    private double correctLevel(double level) {
        if (level > 100) {
            return 100;
        }
        if (level < 0) {
            return 0;
        }
        return level;
    }

    public void setFuelLevel(double level) {
        this.fuelLevel = correctLevel(level);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return number == plane.number && title.equals(plane.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, number);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "title='" + title + '\'' +
                ", number=" + number +
                '}';
    }


}
