package ru.academyit.javacore.lesson5.homework.factory;

/**
 * Класс автомобильного завода.
 */
public class CarFactory {
    private String titleFactory;
    private String[] modeLine;
    private int[] carCount;

    SalesDepartment salesDepartment = new SalesDepartment();

    public CarFactory(String title, String[] modeLine) {
        titleFactory = title;
        this.modeLine = modeLine;
        carCount = new int[modeLine.length];
    }

    public String getTitle() {
        return titleFactory;
    }

    /**
     * В этом методе изготавливаем автомобиль
     *
     * @param title название авто, которое будте в заказе, стоимость завод устанавливает сам
     * @return готовый авто, то объект класса Car
     */
    public Car createCar(Dealer dealer, String title) {
        for (int i = 0; i < modeLine.length; i++) {
            if (modeLine[i].equals(title)) {
                System.out.println("Начинается сборка авто " + title + " на заводе " + titleFactory);
                carCount[i]++;
                return new Car(title, salesDepartment.calculateCarCostForDealer(dealer));
            }
        }
        return null;
    }

    /**
     * Выводит статистику по выпуску авто (по моделям).
     * Модель - количество
     * Всего выпушено автомобилей.
     */
    public void showNumberCarsCreatedByModel() {
        System.out.println("Статистика по выпуску авто (по моделям)\n");
        System.out.println("Модель\t| Кол-во\n- - -");
        int total = 0;
        for (int i = 0; i < modeLine.length; i++) {
            total += carCount[i];
            System.out.println(modeLine[i] + "\t| " + carCount[i]);
        }
        System.out.println("- - -\nВсего\t" + total);
    }

}
