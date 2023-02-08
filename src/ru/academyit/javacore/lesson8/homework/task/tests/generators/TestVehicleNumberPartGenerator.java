package ru.academyit.javacore.lesson8.homework.task.tests.generators;

import ru.academyit.javacore.lesson8.homework.task.vehicle.generators.Generator;
import ru.academyit.javacore.lesson8.homework.task.vehicle.generators.VehicleSeriesPartGenerator;

public class TestVehicleNumberPartGenerator {

    public static void test() {

        Generator gen = new VehicleSeriesPartGenerator();

        var res = gen.generate();
        System.out.println("TestVehicleNumberPartGenerator.test");
        System.out.println("result -> " + res);

        assert  res != null;

    }

}
