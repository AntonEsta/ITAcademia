package ru.academyit.javacore.lesson1.homework.task1;

import javax.swing.JOptionPane;

/**
 * <p>Курс
 * <a href=https://academyit.ru>АКАДЕМИЯ АЙТИ</a> <br>
 * <em>"Разработка бизнес приложений в среде Java и Spring"</em>
 * </p>
 *
 * <p><b>Урок №1. Тема "Программирование в среде Java"</b></p>
 *
 * <p><b>Домашняя работа.</b><br>
 * <em>Задание №1.</em> Вывести на экран текст "Silence is golden". Каждое слово должно быть на новой строке.</p>
 *
 * @author Эста А.В.
 * @implNote Использованы несколько вариантов выполнения задания. Они закоментированы и указываются для справки/памятки способов выведения текстовой информации.
 */
public class PrintGoldenIsSilence {
    public static void main(String[] args) {

        // С применением форматирования
        System.out.printf("%s\n%s\n%s\n", "Silence", "is", "golden!");

        // С использованием UI (Java Swing)
        JOptionPane.showMessageDialog(null, "Silence\n  is\ngolden!");

//        // С применением метода print() со знаками форматиования
//        System.out.print("Silence\n  is\ngolden!\n");

//        // С применением метода println()
//        System.out.println("Silence");
//        System.out.println("  is");
//        System.out.println("golden");

//        // С применениям текстового блока (c Java 15)
//        System.out.println("""
//                Silence
//                  is
//                golden!""");

    }

}