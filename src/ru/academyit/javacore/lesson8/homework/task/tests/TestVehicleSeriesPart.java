package ru.academyit.javacore.lesson8.homework.task.tests;

import ru.academyit.javacore.lesson8.homework.task.exceptions.FormatException;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumberPart;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleSeriesPart;

public class TestVehicleSeriesPart {

    public static void runAll() {

        System.out.println("\n-- TestVehicleSeriesPart --");

        System.out.println("TestVehicleSeriesPart - тесты создание объектов");
        testCreateObject();

        System.out.println("TestVehicleSeriesPart - тесты сравнения объектов");
        testCompareObjects();

        System.out.println("TestVehicleSeriesPart - тесты сравнения hashCode объектов");
        testHashCodeObjects();

        System.out.println("TestVehicleSeriesPart - парсера");
        testParseSeries();
    }

    private static void testParseSeries() {
        System.out.println("\tTestVehicleSeriesPart.testParseSeries");
        System.out.println("\t\tParse \"A234AA76\" -> " + VehicleSeriesPart.parseSeries("А234АА076"));
        try {
            VehicleSeriesPart.parseSeries("А234А023");
        } catch (IllegalArgumentException e) {
            System.out.println("\t\tParse \"A234A023\" -> " + e.getMessage());
        }
    }

    public static void testCreateObject() {

        System.out.println("\tTestVehicleSeriesPart.testCreateObject");

        String strPart = "АВС";
        String[] strFailParts = new String[]{"A32", "ыва", "АВ\nС", "7843", null, "", "234wc f wfw"};

        var series = VehicleSeriesPart.valueOf(strPart);
        assert series.getValue().equals(strPart) : "Создание объекта из строки не корректно! (" + series.getValue() + " != " + strPart + ")";
        System.out.println("\t\tСоздан объект (" + strPart + ") " + series.getValue().equals(strPart));

        for (String strFailPart : strFailParts) {
            VehicleNumberPart o;
            try {
                o = VehicleNumberPart.valueOf(strFailPart);
                assert true : "Тест провален! (o.value = " + o.getValue() + " test = " + strFailPart + ")";
            } catch (IllegalArgumentException | NullPointerException ignored) {
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

        var series1 = VehicleSeriesPart.valueOf("АВС");
        var series2 = VehicleSeriesPart.valueOf("АВС");

        assert series1.hashCode() == series2.hashCode() : "Тест не пройден! Объекты не равны между собой!";

        assert VehicleSeriesPart.valueOf("АВС").hashCode() != VehicleSeriesPart.valueOf("АВТ").hashCode();

    }

}
