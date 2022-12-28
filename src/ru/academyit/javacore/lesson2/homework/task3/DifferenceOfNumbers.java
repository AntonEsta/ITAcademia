package ru.academyit.javacore.lesson2.homework.task3;

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
 * <em>Задание №3.</em> - Написать программу сравнения двух случайных чисел. В результате должна содержаться - на сколько одно число больше другого.
 *     Используйте модуль числа.</p>
 *
 * @author Эста А.В.
 *
 */
public class DifferenceOfNumbers {
    public static void main(String[] args) {

        double num1 = Math.random() * 100;
        double num2 = Math.random() * 100;

        System.out.printf("Разность чисел %.2f и %.2f составляет %.2f", num1, num2, Math.abs(num1-num2));

    }

}