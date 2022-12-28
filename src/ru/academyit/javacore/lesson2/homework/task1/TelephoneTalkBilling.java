package ru.academyit.javacore.lesson2.homework.task1;

import ru.academyit.javacore.lesson2.homework.task1.cash.Position;
import ru.academyit.javacore.lesson2.homework.task1.cash.Receipt;
import ru.academyit.javacore.lesson2.homework.task1.cash.ReceiptHandler;
import ru.academyit.javacore.lesson2.homework.task1.discounts.*;
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
 *
 */
public class TelephoneTalkBilling {
    public static void main(String[] args) {

        double costOfSecond = 2.99; // стоимость секунды разговора

        int seconds = 120; // количество проговоренных секунд

        Receipt receipt = new Receipt();
        Product product = new Product("Междугородний звонок (по-секундная тарификация)", costOfSecond); // создаем продукт
        receipt.addPosition(new Position(product, seconds)); // добавляем продукт в счет

        // создаем скидку "Выходного дня" (действует в выходные дни)
        WeekendDiscount disc = new WeekendDiscount(new PercentageOfTheCostOfTheProductDiscount(20, "Скидка 20%"), "Скидка выходного дня.");
        Discounts.getInstance().addProductDiscount(product, disc); // добавляем продукт и скидку в обработчик скидок
        Product productDisc = Discounts.getInstance().getProductWithDiscounts(product); // получаем продукт с учетом скидки



        System.out.printf("Общая стоимость без учета скидок составила: %.2f р.\n", ReceiptHandler.totalCost(receipt));
        receipt.replacePosition(product, productDisc);
        System.out.printf("Общая стоимость составила: %.2f р. (с учетом скидок)\n", ReceiptHandler.totalCost(receipt));

//        System.out.printf("Общая скидка составила: %.2f р.", ReceiptHandler.totalCost(receipt));



//        int totalDiscount; // общая скидка

//        double cost = costOfSecond * seconds;
//
//        if ( DayOfWeek.of(LocalDate.now().getDayOfWeek().getValue()) == DayOfWeek.WEDNESDAY || DayOfWeek.of(LocalDate.now().getDayOfWeek().getValue()) == DayOfWeek.SUNDAY) {
//            cost = Discounts.percentOf(cost, 20);
//        }

//        System.out.printf("Стоимость без учёта скидки составила: ", );

    }

}