package ru.academyit.javacore.lesson5.homework.factory;

import java.util.Objects;

/**
 * Класс отдела продаж.
 */
public class SalesDepartment {

    /**
     * Рассчитывает стоимость автомобиля для указанного дилера.
     *
     * @param dealer дилер подавший заказ.
     * @return стоимость автомобиля.
     */
    public int calculateCarCostForDealer(Dealer dealer) {
        if (Objects.isNull(dealer)) {
            throw new NullPointerException();
        }
        final int SALE_FOR_DEALER_EXPERIENCE_GT_10 = 10;
        int cost = (int) (Math.random() * 4000 + 1000);
        System.out.println("\t- Начальная стоимость автомобиля составила: " + cost);
        if (dealer.getExperience() >= 10) {
            System.out.println("\t* Предоставляется скидка в размере 10% от стоимости автомобиля.");
            cost -= cost * SALE_FOR_DEALER_EXPERIENCE_GT_10 / 100;
        }
        System.out.println("\tКонечная стоимость составила: " + cost);
        return cost;
    }

}
