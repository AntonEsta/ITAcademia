package ru.academyit.javacore.lesson11.homework.task01;


// Дано слово из четного числа букв. Поменять местами его половины. Вывести полученную строку в верхнем регистре.
public class Main {

    public static void main(String[] args) {

        String strSource = "ОдинДваТриЧетыреПятьШестьСемьВосемьДевятьДесять.";

        String strResult = changeHalvesString(strSource)
                .toUpperCase();
        System.out.printf("Исходная строка: %s\nРезультат: %s", strSource, strResult);
    }

    /**
     * Делит строку пополам и меняет половины местами
     * @param s исходная строка (! метод обрабатывает только строки с чётным количеством символов)
     * @return обработанная строка
     */
    static String changeHalvesString(String s) {
        if (s == null) {
            throw new NullPointerException("Cannot invoke \"changeHalvesString()\" because \"s\" is null");
        }
        if (s.isEmpty() || s.isBlank() || s.length() < 2) {
            return s;
        }
        if (s.length() % 2 != 0) {
            throw new IllegalArgumentException("Строка должна состоять из чётного колличества символов.");
        }
        return s.substring(s.length() / 2).
                concat(s.substring(0, s.length()/2));
    }

}
