package ru.academyit.javacore.lesson5.homework.factory;

public class Main {
    public static void main(String[] args) {

        String[] factoryModels = {"Гранта", "Веста", "Нива"};
        var factory = new CarFactory("АвтоВаз", factoryModels);
        int count = (int) (Math.random() * 20 + 10);

        Dealer dealer = new Dealer("Элвис", 2020);

        String[] orderModels = {"Гранта", "Веста", "Нива", "X-Ray"};
        dealer.makeOrder(factory, count, orderModels);

        System.out.println();

        factory.showNumberCarsCreatedByModel();
    }
}
