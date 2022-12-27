package ru.academyit.javacore.lesson1.homework.task4.advanced;

import javax.swing.*;
import java.time.Year;
import java.util.OptionalInt;

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

    public static final int RETIREMENT_AGE = 65;

    public static void main(String[] args) {

        int yearOfBirth = getInputYearFromUIDialog().orElse(1900);

        int age = (Year.now().getValue() - yearOfBirth);

        if (age < 1) {
            JOptionPane.showMessageDialog(null, "Вы слишком молоды для расчетов!", "Результат", JOptionPane.INFORMATION_MESSAGE);
        } else if (age > 120) {
            JOptionPane.showMessageDialog(null, "Вы слишком молоды для расчетов!", "Результат", JOptionPane.INFORMATION_MESSAGE);
        } else if (yearsBeforeRetirement(age) == 0) {
            JOptionPane.showMessageDialog(null, "Сейчас Вам: " + age + "\nВы достигли пенсионного возраста!", "Результат", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Сейчас Вам " + age + ".\nДо пенсии осталось: " + yearsBeforeRetirement(age), "Результат", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /**
     * Получает год рождения с графической формы диалогового окна
     *
     * @return Опциональное целочисленное значение год рождения
     * При ошибке ввода возращает <em>пустое</em> значение.
     */
    private static OptionalInt getInputYearFromUIDialog() {
        OptionalInt year = OptionalInt.empty();
        try {
            year = OptionalInt.of(Integer.parseInt(JOptionPane.showInputDialog(null, "В каком году Вы роделись?", "Ввод данных", JOptionPane.PLAIN_MESSAGE)));
        } catch (NumberFormatException e) {
            if ("empty String".equals(e.getMessage())) {
                JOptionPane.showMessageDialog(null, "Ошибка во входных данных.\nВведена пустая строка", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ошибка во входных данных.\nВведены не числовые значения", "Ошибка!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Throwable e) {
            JOptionPane.showMessageDialog(null, "Что-то пошло не так! \n " + e.getMessage(), "Ошибка!", JOptionPane.ERROR_MESSAGE);
        }
        return year;
    }

    /**
     * Вычисляет количество лет до достижения пенсионного возраств.
     *
     * @param age Возраст на данный момент
     * @return Количество лет до пенсионного возраста
     */
    private static int yearsBeforeRetirement(int age) {
        if (age >= RETIREMENT_AGE) {
            return 0;
        }
        return age - RETIREMENT_AGE;
    }

}
