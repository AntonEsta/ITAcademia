package ru.academyit.javacore.lesson5.homework.factory;

public class OrderHandler {

    private OrderHandler() {
    }

    /**
     * Выполнение заказа.
     */
    public static void startOrder(Order order) {
        var cars = order.getCars();
        for (var i = 0; i < cars.length; i++) {
            cars[i] = order.getFactory().createCar(order.getDealer(), order.getModels()[(int) (Math.random() * order.getModels().length)]);
        }
    }

}
