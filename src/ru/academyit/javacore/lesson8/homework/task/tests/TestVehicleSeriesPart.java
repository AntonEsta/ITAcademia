package ru.academyit.javacore.lesson8.homework.task.tests;

import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumberPart;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleSeriesPart;

import java.math.BigDecimal;

public class TestVehicleSeriesPart {

    public static void runAll() {
        System.out.println("TestVehicleSeriesPart - тесты создание объектов");
        testCreateObject();

        System.out.println("TestVehicleSeriesPart - тесты сравнения объектов");
        testCompareObjects();

        System.out.println("TestVehicleSeriesPart - тесты сравнения hashCode объектов");
        testHashCodeObjects();
    }

    public static void testCreateObject() {

        String strPart = "ABC";
        String[] strFailParts = new String[]{"A32", "ыва", "АВ\nС", "7843", null, "", "234wc f wfw"};

        var series = VehicleSeriesPart.valueOf(strPart);
        assert series.getValue().equals(strPart) : "Создание объекта из строки не корректно! (" + series.getValue() + " != " + strPart + ")";

        for (String strFailPart : strFailParts) {
            VehicleNumberPart o;
            try {
                o = VehicleNumberPart.valueOf(strFailPart);
                assert o == null : "Тест провален! (o.value = " + o.getValue() + " test = " + strFailPart + ")";
            } catch (NullPointerException | IllegalArgumentException ignored) {
            }
        }

    }

    public static void testCompareObjects() {


        var number1 = VehicleNumberPart.valueOf("234");
        var number2 = VehicleNumberPart.valueOf("234");
        var number3 = VehicleNumberPart.valueOf("789");

        assert number1.compareTo(number2) == 0 : "Тест не пройден! Объекты не равны между собой!";
        assert number1.compareTo(number3) != 0 : "Тест не пройден! Объекты не равны между собой!";

    }

    public static void testHashCodeObjects() {

        var series1 = VehicleSeriesPart.valueOf("ABC");
        var series2 = VehicleSeriesPart.valueOf("ABC");

        assert series1.hashCode() == series2.hashCode(): "Тест не пройден! Объекты не равны между собой!";


    }

}
