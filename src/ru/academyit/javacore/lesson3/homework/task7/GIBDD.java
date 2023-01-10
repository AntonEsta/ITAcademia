package ru.academyit.javacore.lesson3.homework.task7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * <p>Курс
 * <a href=https://academyit.ru>АКАДЕМИЯ АЙТИ</a> <br>
 * <em>"Разработка бизнес приложений в среде Java и Spring"</em>
 * </p>
 *
 * <p><b>Урок №3. Тема "Управляющие конструкции: условия и циклы. Функции и алгоритмы."</b></p>
 *
 * <p><b>Домашняя работа.</b><br>
 * <em>Задание №7.</em> Задания по классу ГИБДД:
 * <ul><li>исправить код таким образом, чтобы ГИБДД не выписывала штраф в
 * случае, если скорость движения ТС ниже 80 км/ч.</li>
 * <li>исправить код так, чтобы штраф был уменьшен в 2 раза, если срок
 * оплаты менее 30 дней.</li></ul>
 *
 * @author Эста А.В.
 */
public class GIBDD {

    public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
        Integer maxAccessSpeed = 80;//макс. разрешенная скорость
        Integer speedGrade = 20;//коэффициент штрафа, каждые 20 км/ч штраф увелич. на 500р
        Integer fineGrade = 500;
        Integer dangerSpeed = 180;
        final long DAYS_MILLISECONDS = 2592000000L; // 30 дней в миллисекундах (для определения скидки на штраф)
        final String DATE_FORMAT_PATTERN = "dd.MM.y";


        System.out.println("введите скорость");
        Integer speed = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());

        if (speed > dangerSpeed) {
            System.out.println("Немедленно остановитесь!");
        } else if (speed > maxAccessSpeed) {
            Integer overSpeed = speed - maxAccessSpeed;//скорость превышения
            Integer k = overSpeed < speedGrade ? 1 : overSpeed / speedGrade;//коэффициент превышения скорости
            int fine = k * fineGrade;//величина штрафа

            System.out.println("Штраф составляет " + fine);
            // получить время фиксации штрафа
            Date fineDate = null;

            do {
                SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
                try {
                    System.out.println("Введите дату фиксации штрафа (ДД-ММ-ГГГГ) ");
                    String strDate = new BufferedReader(new InputStreamReader(System.in)).readLine();
                    if ("".equals(strDate)) {
                        fineDate = new Date();
                        System.out.println("Дата фиксации штрафа принята сегодняшним днем ("
                                + dateFormat.format(fineDate) + ")");
                    } else {
                        fineDate = dateFormat.parse(strDate);
                    }
                } catch (ParseException ex) {
                    System.out.println("Введена дата в неверном формате.");
                }
            } while (Objects.isNull(fineDate));

            // начислить понижающий коэффициент если время от фиксации штрафа менее 30 суток

            if ((new Date().getTime() - fineDate.getTime()) <= DAYS_MILLISECONDS) {
                System.out.println("Применён понижающий коэффициент 0.5");
                fine /= 2;
            }

            // вывести итоговый отчет по штрафу
            System.out.printf("""
                                                
                            Дата фиксации штрафа: %s
                            К оплате: %d
                            """,
                    new SimpleDateFormat(DATE_FORMAT_PATTERN).format(fineDate),
                    fine);
        } else {
            System.out.println("Доброго пути!");
        }

    }

}