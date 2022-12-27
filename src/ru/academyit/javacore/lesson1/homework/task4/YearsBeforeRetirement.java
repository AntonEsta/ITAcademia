package ru.academyit.javacore.lesson1.homework.task4;

import javax.swing.*;
import java.time.Year;

/**
 * <p>Курс
 * <a href=https://academyit.ru>АКАДЕМИЯ АЙТИ</a> <br>
 * <em>"Разработка бизнес приложений в среде Java и Spring"</em>
 * </p>
 *
 * <p><b>Урок №1. Тема "Программирование в среде Java"</b></p>
 *
 * <p><b>Домашняя работа.</b><br>
 * <em>Задание №4.</em><br>
 *    <ul>
 *    <li>Спросить у пользователя год рождения</li>
 *    <li>Вывести информацию о его возрасте в текущем году (использовать метод java для получение текущего года)</li>
 *    <li>Вывести сколько ему осталось работать до пенсии. Считаем, что пенсионный возраст: 65 лет.</li>
 *    </ul>
 * </p>
 *
 * @author Эста А.В.
 */
public class YearsBeforeRetirement {

    public static void main(String[] args) {

        int yearOfBirth = Integer.parseInt(JOptionPane.showInputDialog(null, "В каком году Вы роделись?", "Ввод данных", JOptionPane.PLAIN_MESSAGE));
        int age = (Year.now().getValue() - yearOfBirth);
        JOptionPane.showMessageDialog(null, "Сейчас Вам " + age + ".\nДо пенсии осталось: " + (65 - age), "Результат", JOptionPane.INFORMATION_MESSAGE);

    }

//    public static void main(String[] args) {
//
//        // получаем год рождени пользователя
//        Year yearOfBirth = Year.of(Integer.parseInt(JOptionPane.showInputDialog(null, "В каком году Вы роделись?", "Ввод данных", JOptionPane.PLAIN_MESSAGE)));
//        int age = Year.now().compareTo(yearOfBirth); // получаем разницу в годах
//        // ... дальнейшая обработка бла-бла-бла
//        JOptionPane.showMessageDialog(null, "Сейчас Вам " + age + ".\nДо пенсии осталось: " + (65 - age), "Результат", JOptionPane.INFORMATION_MESSAGE);
//
//    }

}
