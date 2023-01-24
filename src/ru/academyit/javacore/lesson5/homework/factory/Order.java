package ru.academyit.javacore.lesson5.homework.factory;

import java.util.Objects;

public class Order {

    private final Dealer dealer;
    private final CarFactory factory;
    private final String[] models;
    private final Car[] cars;

    public Order(Dealer dealer, CarFactory factory, int count, String[] models) {
        this.dealer = dealer;
        this.factory = factory;
        this.models = models;
        this.cars = new Car[count];
    }

    /**
     * Выводит информацию о заказе.
     * <ul><li>Перечень выполненных позиций с указанием модели и стоимости.</li>
     * <li>Количество выполненных и не выполненных позиций.</li>
     * <li>Процент реализации заказа.</li>
     * <li>Общую стоимость заказа.</li></ul>
     */
    void showInfoOrder() {
        System.out.println("Информация о заказе");
        int emptyPlaces = 0;
        int completePlaces = 0;
        int poz = 1;
        for (var car : cars) {
            if (Objects.nonNull(car)) {
                System.out.println(poz++ + ". Автомобиль " + car.getTitle() + " стоит " + car.getPrice());
                completePlaces++;
            } else {
                emptyPlaces++;
            }
        }
        System.out.println("- - -");
        System.out.println("Выполненных позиций: " + completePlaces + "/" + cars.length);
        System.out.println("Не выполненных позиций: " + emptyPlaces + "/" + cars.length);
        System.out.println("Реализация заказа: " + (int) (((double) (cars.length - emptyPlaces) / cars.length) * 100) + "%");
        System.out.println("Общая сумма заказа: " + getTotalCost());
    }

    /**
     * Считает полную стоимость заказа.
     *
     * @return стоимость заказа.
     */
    public int getTotalCost() {
        int sum = 0;
        for (Car car : cars) {
            if (Objects.nonNull(car)) {
                sum += car.getPrice();
            }
        }
        return sum;
    }

    public CarFactory getFactory() {
        return factory;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public String[] getModels() {
        return models;
    }

    public Car[] getCars() {
        return cars;
    }

}
