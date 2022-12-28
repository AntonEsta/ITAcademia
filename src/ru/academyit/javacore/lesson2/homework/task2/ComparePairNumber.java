package ru.academyit.javacore.lesson2.homework.task2;

import ru.academyit.javacore.lesson2.homework.task1.cash.Position;
import ru.academyit.javacore.lesson2.homework.task1.cash.Receipt;
import ru.academyit.javacore.lesson2.homework.task1.cash.ReceiptHandler;
import ru.academyit.javacore.lesson2.homework.task1.discounts.Discounts;
import ru.academyit.javacore.lesson2.homework.task1.discounts.PercentageOfTheCostOfTheProductDiscount;
import ru.academyit.javacore.lesson2.homework.task1.discounts.WeekendDiscount;
import ru.academyit.javacore.lesson2.homework.task1.product.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <p>Курс
 * <a href=https://academyit.ru>АКАДЕМИЯ АЙТИ</a> <br>
 * <em>"Разработка бизнес приложений в среде Java и Spring"</em>
 * </p>
 *
 * <p><b>Урок №1. Тема "Считывание данных с консоли. Класс Scanner. Управляющие конструкции: условия и циклы."</b></p>
 *
 * <p><b>Домашняя работа.</b><br>
 * <em>Задание №2.</em> - Объявить две целочисленные переменные "a" и "b"
 *     - Задать им произвольные начальные значения
 *     - Написать скрипт, который работает по следующему принципу:
 *             если "a" и "b" положительные, то вывести их разность;
 *             если "a" и "b" отрицательные, то вывести их произведение;
 *             если "a" и "b" разных знаков, то вывести их сумму..</p>
 *
 * @author Эста А.В.
 *
 */
public class ComparePairNumber {
    public static void main(String[] args) {

        int a = 0;
        int b = 0;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Введите первое число (a): ");
            a = sc.nextInt();
            System.out.print("Введите второе число (b): ");
            b = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введены не корректные данные!");
        }

        if (a > 0 && b > 0) {
            System.out.println("a-b=" + (a-b));
        } else if (a<0 && b<0) {
            System.out.println("a*b=" + a*b);
        } else {
            System.out.println("a+b=" + (a+b));
        }

    }

}