package ru.academyit.javacore.lesson1.homework.task3.advanced;

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
 * <em>Задание №3.</em><br>
 * Дано расстояние в метрах. Найти число полных километров в нем.
 * </p>
 *
 * @author Эста А.В.
 */
public class ConvertMetersToKilometersWithExceptionCheck {

    public static void main(String[] args) {

        try {

            double meters = Double.parseDouble(JOptionPane.showInputDialog(null, "Введите расстояние в метрах", "Ввод данных", JOptionPane.PLAIN_MESSAGE));
            JOptionPane.showMessageDialog(null, Convertors.toKilometers(meters), "Результат", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {

            if ("empty String".equals(e.getMessage())) {
                JOptionPane.showMessageDialog(null, "Вы ввели пустую строку!", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Введен не верный формат данных!\nВведите числовое значение!", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Throwable e) {
            JOptionPane.showMessageDialog(null, "Не известная ошибка! \n" + e.getMessage(), "Ошибка!", JOptionPane.ERROR_MESSAGE);
        }

    }


}
