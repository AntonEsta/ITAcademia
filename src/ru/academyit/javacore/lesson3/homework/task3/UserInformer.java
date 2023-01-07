package ru.academyit.javacore.lesson3.homework.task3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;

/**
 * <p>Курс
 * <a href=https://academyit.ru>АКАДЕМИЯ АЙТИ</a> <br>
 * <em>"Разработка бизнес приложений в среде Java и Spring"</em>
 * </p>
 *
 * <p><b>Урок №3. Тема "Управляющие конструкции: условия и циклы. Функции и алгоритмы."</b></p>
 *
 * <p><b>Домашняя работа.</b><br>
 * <em>Задание №3.</em> Создать метод, который принимает имя и возраст. Вернуть строковую информацию о
 * имени и годе рождения.</p>
 *
 * @author Эста А.В.
 */
public class UserInformer {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // получить имя пользователя
        String name;
        while (true) {
            System.out.print("Введите имя: ");
            name = reader.readLine();
            if (!"".equals(name)) {
                break;
            }
            System.out.println("Вы ввели некорректное значение имени.");
        }

        // получить возраст пользователя
        int age;
        while (true) {
            System.out.print("Введите возраст: ");
            try {
                age = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException ex) {
                System.out.println("Не верный формат числа.");
                continue;
            }
            if (age > 0) {
                break;
            }
            System.out.println("Вы ввели некорректное значение возраста.");
        }

        // вычислить год рождения
        Year birthYear = Year.now().minusYears(age);

        // вывести информацию о пользователе
        System.out.println();
        System.out.println("Имя: " + name);
        System.out.println("Год рождения: " + birthYear);

    }


}
