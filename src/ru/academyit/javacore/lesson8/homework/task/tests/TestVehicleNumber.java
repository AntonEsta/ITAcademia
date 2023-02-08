package ru.academyit.javacore.lesson8.homework.task.tests;

import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumber;
import ru.academyit.javacore.lesson8.homework.task.vehicle.generators.VehicleNumberPartGenerator;
import ru.academyit.javacore.lesson8.homework.task.vehicle.generators.VehicleRegionCodePartGenerator;
import ru.academyit.javacore.lesson8.homework.task.vehicle.generators.VehicleSeriesPartGenerator;

public class TestVehicleNumber {

    public static void runAll() {
        System.out.println("TestVehicleNumberPart - тесты создание объектов");
        testCreateObject();
    }

    public static void testCreateObject() {

        var number = new VehicleNumber(
                new VehicleSeriesPartGenerator().generate(),
                new VehicleNumberPartGenerator().generate(),
                new VehicleRegionCodePartGenerator().generate());

        System.out.println(number);

    }
}
