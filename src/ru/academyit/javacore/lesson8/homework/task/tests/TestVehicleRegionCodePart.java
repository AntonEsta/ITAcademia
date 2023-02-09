package ru.academyit.javacore.lesson8.homework.task.tests;

import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleRegionCodePart;

import java.math.BigDecimal;

public class TestVehicleRegionCodePart {

    public static void runAll() {
        System.out.println("\n-- TestVehicleRegionCodePart --");

        System.out.println("TestVehicleRegionCodePart - тесты создание объектов");
        testCreateObject();

        System.out.println("TestVehicleRegionCodePart - тесты сравнения объектов");
        testCompareObjects();

        System.out.println("TestVehicleRegionCodePart - тесты сравнения hashCode объектов");
        testHashCodeObjects();

        System.out.println("TestVehicleRegionCodePart - парсера");
        testParseRegionCode();

    }

    private static void testParseRegionCode() {
        System.out.println("\tTestVehicleRegionCodePart.testParseRegionCode: ");
        System.out.println("\t\tParse \"A234AA76\" -> " + VehicleRegionCodePart.parseRegionCode("A234AA76"));
        try {
            VehicleRegionCodePart.parseRegionCode("A234AA");
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("\t\tParse \"A234AA\" -> " + e.getMessage());
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

        var number = VehicleRegionCodePart.valueOf(strPart);
        assert number.getValue().equals(strPart) : "Создание объекта из строки не корректно! (" + number.getValue() + " != " + strPart + ")";

        for (String strFailPart : strFailParts) {
            VehicleRegionCodePart o;
            try {
                o = VehicleRegionCodePart.valueOf(strFailPart);
                assert true : "Тест провален! (o.value = " + o.getValue() + " test = " + strFailPart + ")";
            } catch (NullPointerException | IllegalArgumentException ignored) {
            }
        }

        number = VehicleRegionCodePart.valueOf(intPart);
        assert number.getValue().equals(String.format("%03d", intPart)) : "Создание объекта из строки не корректно! (" + number.getValue() + " != " + intPart + ")";

        number = VehicleRegionCodePart.valueOf(dPart);
        assert number.getValue().equals(String.format("%03d", (int) dPart)) : "Создание объекта из строки не корректно! (" + number.getValue() + " != " + dPart + ")";

        number = VehicleRegionCodePart.valueOf(dicPart);
        assert number.getValue().equals(String.valueOf(dicPart.intValue())) : "Создание объекта из строки не корректно! (" + number.getValue() + " != " + dicPart + ")";

        for (Number item : dicFailParts) {
            VehicleRegionCodePart o;
            try {
                o = VehicleRegionCodePart.valueOf(item);
                assert true : "Тест провален! (o.value = " + o.getValue() + " test = " + item + ")";
            } catch (NullPointerException | IllegalArgumentException ignored) {
            }
        }

    }

    public static void testCompareObjects() {


        var number1 = VehicleRegionCodePart.valueOf("234");
        var number2 = VehicleRegionCodePart.valueOf("234");
        var number3 = VehicleRegionCodePart.valueOf("789");

        assert number1.compareTo(number2) == 0 : "Тест не пройден! Объекты не равны между собой!";
        assert number1.compareTo(number3) != 0 : "Тест не пройден! Объекты не равны между собой!";

    }

    public static void testHashCodeObjects() {

        var number1 = VehicleRegionCodePart.valueOf("234");
        var number2 = VehicleRegionCodePart.valueOf("234");

        assert number1.hashCode() == number2.hashCode() : "Тест не пройден! Объекты не равны между собой!";


    }


}
