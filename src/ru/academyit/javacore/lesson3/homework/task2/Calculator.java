package ru.academyit.javacore.lesson3.homework.task2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * <p>Курс
 * <a href=https://academyit.ru>АКАДЕМИЯ АЙТИ</a> <br>
 * <em>"Разработка бизнес приложений в среде Java и Spring"</em>
 * </p>
 *
 * <p><b>Урок №3. Тема "Управляющие конструкции: условия и циклы. Функции и алгоритмы."</b></p>
 *
 * <p><b>Домашняя работа.</b><br>
 * <em>Задание №2.</em> Создать 4 метода для расчета суммы, разности, произведения и деления двух чисел.
 * Создать пятый метод, который принимает 3 параметра – два числа и знак операции.
 * На основании знака операции необходимо вызывать ранее созданный метод и
 * получать результат операции.</p>
 *
 * @author Эста А.В.
 */
public class Calculator {

    public static void main(String[] args) throws IOException {

        var reader = new BufferedReader(new InputStreamReader(System.in));

        double num1, num2;

        // получаем первое число для вычислений
        while (true) {
            System.out.print("Введите первое число: ");
            try {
                num1 = Double.parseDouble(reader.readLine());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Не верный формат числа.");
            }
        }

        // получаем знак действия
        System.out.print("Введите действие: ");
        char action = reader.readLine().charAt(0);

        // получаем второе число для вычислений
        while (true) {
            System.out.print("Введите второе число: ");
            try {
                num2 = Double.parseDouble(reader.readLine());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Не верный формат числа.");
            }
        }

        // вычисление
        try {
            var decimalFormat = new DecimalFormat("#.########");
            System.out.printf("%s %s %s = %s",
                    decimalFormat.format(num1),
                    action,
                    decimalFormat.format(num2),
                    decimalFormat.format(calculate(action, num1, num2)));
        } catch (NoSuchMethodException ex) {
            System.out.println("Операция \"" + action + "\" не распознана.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        reader.close();
    }

    /**
     * Производит арифметическое действие над двумя числами.
     *
     * @param action знак арифметического действия
     * @param num1   первое число для вычислений
     * @param num2   второе число для вычислений
     * @return результат вычислений
     * @throws NoSuchMethodException исключение генерируется,
     *                               если указанные арифметическое действие не распознано.
     */
    static double calculate(char action, double num1, double num2) throws NoSuchMethodException {

        switch (action) {
            case '+':
                return sum(num1, num2);
            case '-':
                return minus(num1, num2);
            case '*':
                return mul(num1, num2);
            case '/':
                try {
                    return div(num1, num2);
                } catch (ArithmeticException ex) {
                    System.out.println(ex.getMessage());
                    throw ex;
                }
            default:
                throw new NoSuchMethodException();
        }

    }

    /**
     * Вычисляет сумму двух чисел.
     *
     * @param num1 первое слагаемое
     * @param num2 второе слагаемое
     * @return сумма
     */
    static double sum(double num1, double num2) {
        return num1 + num2;
    }

    /**
     * Вычисляет разность двух чисел.
     *
     * @param num1 уменьшаемое
     * @param num2 вычитаемое
     * @return разность
     */
    static double minus(double num1, double num2) {
        return num1 - num2;
    }

    /**
     * Производит деление двух чисел.
     *
     * @param num1 делимое
     * @param num2 делитель
     * @return частное
     */
    static double div(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Деление на ноль не допустимо.");
        }
        return num1 / num2;
    }

    /**
     * Вычисляет произведение двух чисел
     *
     * @param num1 первый множитель
     * @param num2 второй множитель
     * @return произведение
     */
    static double mul(double num1, double num2) {
        return num1 * num2;
    }

}
