package ru.academyit.javacore.lesson8.homework.task.tests.generators;

import ru.academyit.javacore.lesson8.homework.task.vehicle.generators.VehicleSeriesPartGenerator;

public class TestVehicleRegionCodePartGenerator {

    public static void test() {

        var gen = new VehicleSeriesPartGenerator();

        assert gen.generate() != null;

    }

}
