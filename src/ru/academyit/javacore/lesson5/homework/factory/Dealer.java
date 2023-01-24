package ru.academyit.javacore.lesson5.homework.factory;

import java.time.Year;

/**
 * Класс дилера.
 */
public class Dealer {
    private String titleDealer;
    private final int sinceDealer;

    public Dealer(String titleDealer, int sinceDealer) {
        if (titleDealer.isBlank()) {
            throw new IllegalArgumentException("Название дилера не может быть пустым.");
        }
        if (Year.of(sinceDealer).isAfter(Year.now())) {
            throw new IllegalArgumentException("Год начала деятельности дилера ещё не настал.");
        }
        this.titleDealer = titleDealer;
        this.sinceDealer = sinceDealer;
    }

    /**
     * Осуществляет заказ партии автомобилей автозаводу.
     *
     * @param factory атомобильный завод с которым нужно работать.
     * @param count   количество автомобилей для заказа.
     * @param models  модели автомобилей для заказа.
     */
    void makeOrder(CarFactory factory, int count, String[] models) {
        var order = new Order(this, factory, count, models);
        OrderHandler.startOrder(order);
        order.showInfoOrder();
    }

    /**
     * Возвращает стаж работы дилера на рынке.
     *
     * @return количество лет деятельности дилера.
     */
    public int getExperience() {
        return Year.now().compareTo(Year.of(sinceDealer));
    }

    public String getTitleDealer() {
        return titleDealer;
    }
}
