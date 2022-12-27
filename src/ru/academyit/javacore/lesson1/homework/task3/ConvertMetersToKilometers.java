package ru.academyit.javacore.lesson1.homework.task3;

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
public class ConvertMetersToKilometers {

    public static void main(String[] args) {
        double meters = Double.parseDouble(JOptionPane.showInputDialog(null, "Введите расстояние в метрах", "Ввод данных", JOptionPane.PLAIN_MESSAGE));
        JOptionPane.showMessageDialog(null, (long) (meters / 1000), "Результат", JOptionPane.INFORMATION_MESSAGE);
    }

}
