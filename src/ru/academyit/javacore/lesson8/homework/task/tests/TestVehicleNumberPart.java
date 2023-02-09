package ru.academyit.javacore.lesson8.homework.task.tests;

import ru.academyit.javacore.lesson8.homework.task.exceptions.FormatException;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumberPart;

import java.math.BigDecimal;

public class TestVehicleNumberPart {

    public static void runAll() {
        System.out.println("TestVehicleNumberPart - тесты создание объектов");
        testCreateObject();

        System.out.println("TestVehicleNumberPart - тесты сравнения объектов");
        testCompareObjects();

        System.out.println("TestVehicleNumberPart - тесты сравнения hashCode объектов");
        testHashCodeObjects();

        System.out.println("TestVehicleNumberPart - парсера");
        testParseNumber();
    }

    private static void testParseNumber() {
        System.out.println("Parse \"A234AA177\" -> " + VehicleNumberPart.parseNumber("A234AA177"));
        try {
            VehicleNumberPart.parseNumber("AA17");
        } catch (FormatException e) {
            System.out.println("Parse \"AA17\" -> FormatException");
        }
    }

    public static void testCreateObject() {

        var strPart = "034";
        var intPart = 4;
        var dPart = 234.23;
        var dicPart = new BigDecimal("234.325223");

        String[] strFailParts = new String[]{"A32", "okfm", "23\n3", "7843", null, "", "234wc f wfw"};
        Number[] dicFailParts = new BigDecimal[]{
                new BigDecimal("34325223"),
                null};

        var number = VehicleNumberPart.valueOf(strPart);
        assert number.getValue().equals(strPart) : "Создание объекта из строки не корректно! (" + number.getValue() + " != " + strPart + ")";

        for (String strFailPart : strFailParts) {
            VehicleNumberPart o;
            try {
                o = VehicleNumberPart.valueOf(strFailPart);
                assert true : "Тест провален! (o.value = " + o.getValue() + " test = " + strFailPart + ")";
            } catch (NullPointerException | IllegalArgumentException ignored) {
            }
        }

        number = VehicleNumberPart.valueOf(intPart);
        assert number.getValue().equals(String.format("%03d", intPart)) : "Создание объекта из строки не корректно! (" + number.getValue() + " != " + intPart + ")";

        number = VehicleNumberPart.valueOf(dPart);
        assert number.getValue().equals(String.format("%03d", (int) dPart)) : "Создание объекта из строки не корректно! (" + number.getValue() + " != " + dPart + ")";

        number = VehicleNumberPart.valueOf(dicPart);
        assert number.getValue().equals(String.valueOf(dicPart.intValue())) : "Создание объекта из строки не корректно! (" + number.getValue() + " != " + dicPart + ")";

        for (Number item : dicFailParts) {
            VehicleNumberPart o;
            try {
                o = VehicleNumberPart.valueOf(item);
                assert true : "Тест провален! (o.value = " + o.getValue() + " test = " + item + ")";
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

        var number1 = VehicleNumberPart.valueOf("234");
        var number2 = VehicleNumberPart.valueOf("234");

        assert number1.hashCode() == number2.hashCode() : "Тест не пройден! Объекты не равны между собой!";


    }


}