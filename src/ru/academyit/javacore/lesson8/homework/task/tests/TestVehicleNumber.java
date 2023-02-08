package ru.academyit.javacore.lesson8.homework.task.tests;

import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumber;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumberPart;
import ru.academyit.javacore.lesson8.homework.task.vehicle.generators.VehicleNumberPartGenerator;
import ru.academyit.javacore.lesson8.homework.task.vehicle.generators.VehicleRegionCodePartGenerator;
import ru.academyit.javacore.lesson8.homework.task.vehicle.generators.VehicleSeriesPartGenerator;

import java.math.BigDecimal;

public class TestVehicleNumber {

    public static void runAll() {
        System.out.println("TestVehicleNumberPart - тесты создание объектов");
        testCreateObject();
//
//        System.out.println("TestVehicleNumberPart - тесты сравнения объектов");
//        testCompareObjects();
//
//        System.out.println("TestVehicleNumberPart - тесты сравнения hashCode объектов");
//        testHashCodeObjects();
    }

    public static void testCreateObject() {

        var number = new VehicleNumber(
                new VehicleSeriesPartGenerator().generate(),
                new VehicleNumberPartGenerator().generate(),
                new VehicleRegionCodePartGenerator().generate());

        System.out.println(number);

    }

//    public static void testCompareObjects() {
//
//
//        var number1 = VehicleNumberPart.valueOf("234");
//        var number2 = VehicleNumberPart.valueOf("234");
//        var number3 = VehicleNumberPart.valueOf("789");
//
//        assert number1.compareTo(number2) == 0 : "Тест не пройден! Объекты не равны между собой!";
//        assert number1.compareTo(number3) != 0 : "Тест не пройден! Объекты не равны между собой!";
//
//    }
//
//    public static void testHashCodeObjects() {
//
//        var number1 = VehicleNumberPart.valueOf("234");
//        var number2 = VehicleNumberPart.valueOf("234");
//
//        assert number1.hashCode() == number2.hashCode(): "Тест не пройден! Объекты не равны между собой!";
//
//
//    }


}
