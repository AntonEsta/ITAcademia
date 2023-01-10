package ru.academyit.javacore.lesson3.homework.task6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>Курс
 * <a href=https://academyit.ru>АКАДЕМИЯ АЙТИ</a> <br>
 * <em>"Разработка бизнес приложений в среде Java и Spring"</em>
 * </p>
 *
 * <p><b>Урок №3. Тема "Управляющие конструкции: условия и циклы. Функции и алгоритмы."</b></p>
 *
 * <p><b>Домашняя работа.</b><br>
 * <em>Задание №6.</em> В игре Казино из урока сделать:
 * <ul><li>возможность играть, пока не закончатся деньги у игрока;</li>
 * <li>игрок может выйти в любой момент если введет -1 вместо ставки.</li></ul>
 *
 * @author Эста А.В.
 */
public class Casino {

    private final static String EXIT_STRING = "-1";

    public static void main(String[] args) throws IOException {


        final int MONEY_LOW_LIMIT = 1000;

        int money;

        System.out.println("В любой момент игры можно выйти введя \"" + EXIT_STRING + "\"");

        while (true) {
            System.out.println("Введите Вашу сумму для начала игры (не менее " + MONEY_LOW_LIMIT + ")");
            try {
                money = Integer.parseInt(readLineWithExitCommandControl());
            } catch (NumberFormatException ex) {
                System.out.println("Сумма не корректна ");
                continue;
            }

            // Недостаточно средств на счету
            if (money < MONEY_LOW_LIMIT) {
                System.out.println("недостаточно средств для начала игры");
                continue;
            }

            break;
        }

        while (money > 0) {

            System.out.println("\nВАШ СЧЁТ : " + money);
            System.out.println();

            int rate;

            while (true) {
                System.out.println("Введите Вашу ставку");
                try {
                    rate = Integer.parseInt(readLineWithExitCommandControl());
                } catch (NumberFormatException ex) {
                    System.out.println("Сумма не корректна ");
                    continue;
                }
                // проверка станки на наличие обеспечения её игроком (наличие средств на счету)
                if (rate > 0 && rate <= money) {
                    System.out.println("Игра началась");
                    break;
                } else {
                    System.out.println("Ставка некорректна");
                }
            }

            int number = (int) (Math.random() * 9 - 1);
            int count = 3;
            final int COUNT_MAX = 4;
            System.out.println("Попытайтесь угадать задуманное число от 0 до 9.");
            while (count > 0) {
                int answer;
                System.out.println("Попытка №" + (COUNT_MAX - count));

                try {
                    answer = Integer.parseInt(readLineWithExitCommandControl());
                } catch (NumberFormatException ex) {
                    System.out.println("Вы ввели не простое число. Повторите попытку.");
                    continue;
                }

                if (answer == number) {
                    System.out.println("Поздравляем, Вы выиграли! Сумма " + (money += rate));
                } else {
                    if (count == 1) {
                        System.out.println("Было загадано:" + number + ", Вы проиграли!" + " Сумма " + (money -= rate));
                    }
                }
                
                count--;
            }


        }

        System.out.println("К сожалению Ваш счет пуст! До новых встреч!");


    }

    /**
     * Читает ввод с консоли, и контролирует ввод команды выхода из программы.
     * @return строка из консоли
     * @throws IOException ошибки i/o.
     */
    static String readLineWithExitCommandControl() throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var resStr = reader.readLine();
        if (EXIT_STRING.equals(resStr)) {
            System.out.println("Игра закончена!");
            System.exit(0);
        }
        reader.close();
        return resStr;
    }

}
