package ru.academyit.javacore.lesson1.homework.task2.advanced;

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
 * @implNote Расширенная версия с проверкой исключений.
 */
public class ThreeNumberCalculationWithExceptionCheck {

    public static void main(String[] args) {

        try {

            double number1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Введите первое число", "Ввод данных", JOptionPane.PLAIN_MESSAGE));
            double number2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Введите второе число", "Ввод данных", JOptionPane.PLAIN_MESSAGE));
            double number3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Введите третье число", "Ввод данных", JOptionPane.PLAIN_MESSAGE));
            JOptionPane.showMessageDialog(null, ThreeNumberCalculationWithExceptionCheck.calculate(number1, number2, number3));

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Ошибка во входных данных.\nЧисло не введено.", "Ошибка!", JOptionPane.ERROR_MESSAGE);

        } catch (NumberFormatException e) {
            if ("empty String".equals(e.getMessage())) {
                JOptionPane.showMessageDialog(null, "Ошибка во входных данных.\nВведена пустая строка", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ошибка во входных данных.\nВведены не числовые значения", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Throwable e) {
            JOptionPane.showMessageDialog(null, "Что-то пошло не так! \n " + e.getMessage(), "Ошибка!", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Вычисляет значение по алгоритму.
     * <ul>
     *     <li>Увеличивает первое число в два раза</li>
     *     <li>Второе число на 3</li>
     *     <li>Третье число возведит в квадрат</li>
     *     <li>Находит сумму новых трех чисел</li>
     * </ul>
     *
     * @param number1 первое число
     * @param number2 второе число
     * @param number3 третье число
     * @return Значение вычисления
     */
    public static double calculate(double number1, double number2, double number3) {
        return number1 * 2 + (number2 - 3) + number3 * number3;
    }

}
