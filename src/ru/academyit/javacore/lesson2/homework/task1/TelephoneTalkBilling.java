package ru.academyit.javacore.lesson2.homework.task1;

import ru.academyit.javacore.lesson2.homework.task1.cash.Receipt;
import ru.academyit.javacore.lesson2.homework.task1.cash.ReceiptHandler;
import ru.academyit.javacore.lesson2.homework.task1.discounts.Discounts;
import ru.academyit.javacore.lesson2.homework.task1.discounts.PercentageOfTheCostOfTheProductDiscount;
import ru.academyit.javacore.lesson2.homework.task1.discounts.WeekendDiscount;
import ru.academyit.javacore.lesson2.homework.task1.product.Product;

/**
 * <p>Курс
 * <a href=https://academyit.ru>АКАДЕМИЯ АЙТИ</a> <br>
 * <em>"Разработка бизнес приложений в среде Java и Spring"</em>
 * </p>
 *
 * <p><b>Урок №1. Тема "Считывание данных с консоли. Класс Scanner. Управляющие конструкции: условия и циклы."</b></p>
 *
 * <p><b>Домашняя работа.</b><br>
 * <em>Задание №1.</em> Написать программу определения стоимости разговора по телефону с учетом скидки 20%, предоставляемой по субботам и воскресеньям.</p>
 *
 * @author Эста А.В.
 */
public class TelephoneTalkBilling {
    public static void main(String[] args) {

        System.out.println("ПРОГРАММА ПРЕДОСТАВЛЯЕТ СКИДКУ НА ТЕКУЩИЙ ДЕНЬ НЕДЕЛИ!");

        double costOfSecond = 2.99; // стоимость секунды разговора
        int seconds = 120; // количество проговоренных секунд

        // создаем чек
        Receipt receipt = new Receipt();
        Product product = new Product("Междугородний звонок (по-секундная тарификация)", costOfSecond); // создаем продукт
        receipt.addPosition(product, seconds); // добавляем позицию в чек

        // создаем скидку "Выходного дня" (действует в выходные дни)
        WeekendDiscount disc = new WeekendDiscount(new PercentageOfTheCostOfTheProductDiscount(20, "Скидка 20%"), "Скидка выходного дня.");
        Discounts.getInstance().addProductDiscount(product, disc); // добавляем продукт и скидку в обработчика скидок
        Product productDisc = Discounts.getInstance().getProductWithDiscounts(product); // получаем продукт с учетом скидки

        double totalCost = ReceiptHandler.totalCost(receipt);

        // отображаем позиции в чеке
        receipt.getPositions().forEach(p -> {
            System.out.println("\t" + p.getProduct().getName());
            System.out.println("\t\tСтоимость (за ед.):\t" + p.getProduct().getCost());
            System.out.println("\t\tКоличество (ед): " + p.getQuantity());
        });

        // выводим информацию о стоимости и скидках
        System.out.printf("Общая стоимость без учета скидок составила: %.2f р.\n", totalCost);
        receipt.getPositions().forEach(p -> Discounts.getInstance().getAllApplyDiscounts(p.getProduct()));
        Discounts.getInstance().getAllApplyDiscounts(product);
        receipt.replacePosition(product, productDisc);

        double totalCostDiscounted = ReceiptHandler.totalCost(receipt);
        System.out.printf("Общая стоимость составила: %.2f р. (с учетом скидок)\n", totalCostDiscounted);
        System.out.printf("Ваша скидка составила: %.2f р.\n", totalCost - totalCostDiscounted);

    }

}