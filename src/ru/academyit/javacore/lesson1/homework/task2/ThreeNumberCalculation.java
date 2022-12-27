package ru.academyit.javacore.lesson1.homework.task2;

import javax.swing.*;

/**
 * <p>Курс
 * <a href=https://academyit.ru>АКАДЕМИЯ АЙТИ</a> <br>
 * <em>"Разработка бизнес приложений в среде Java и Spring"</em>
 * </p>
 *
 * <p><b>Урок №1. Тема "Программирование в среде Java"</b></p>
 *
 * <p><b>Домашняя работа.</b><br>
 * <em>Задание №2.</em><br>
 * Даны три числа. Нужно:
 *    <ul>
 *    <li>Увеличьте первое число в два раза</li>
 *    <li>Второе число на 3</li>
 *    <li>Третье число возведите в квадрат</li>
 *    <li>Наидите сумму новых трех чисел</li>
 *    </ul>
 * </p>
 *
 * @author Эста А.В.
 */
public class ThreeNumberCalculation {

    public static void main(String[] args) {

        double number1 = Double.parseDouble(JOptionPane.showInputDialog("Введите первое число"));
        double number2 = Double.parseDouble(JOptionPane.showInputDialog("Введите второе число"));
        double number3 = Double.parseDouble(JOptionPane.showInputDialog("Введите третье число"));

        JOptionPane.showMessageDialog(null, number1 * 2 + (number2 - 3) + number3 * number3);

    }

}
