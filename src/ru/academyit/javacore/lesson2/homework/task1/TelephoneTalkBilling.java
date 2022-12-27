package ru.academyit.javacore.lesson2.homework.task1;

import ru.academyit.javacore.lesson2.homework.task1.cash.Position;
import ru.academyit.javacore.lesson2.homework.task1.cash.Receipt;
import ru.academyit.javacore.lesson2.homework.task1.cash.ReceiptHandler;
import ru.academyit.javacore.lesson2.homework.task1.product.Product;

import javax.swing.*;
import java.time.DayOfWeek;
import java.time.LocalDate;

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



        double costOfSecond = 2.99;

        int seconds = 120;

        Receipt receipt = new Receipt();
        Product product = new Product("Междугородний звонок", 1.99);
        receipt.addPosition(new Position(product, 130));


        System.out.printf("Общая стоимость составила: %d", ReceiptHandler.totalCost(receipt));


        int totalDiscount; // общая скидка

        double cost = costOfSecond * seconds;

        if ( DayOfWeek.of(LocalDate.now().getDayOfWeek().getValue()) == DayOfWeek.WEDNESDAY || DayOfWeek.of(LocalDate.now().getDayOfWeek().getValue()) == DayOfWeek.SUNDAY) {
            cost = Discounts.percentOf(cost, 20);
        }

        System.out.printf("Стоимость без учёта скидки составила: ", );

    }

}