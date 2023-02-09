package ru.academyit.javacore.lesson8.homework.task.tests.generators;

import ru.academyit.javacore.lesson8.homework.task.vehicle.generators.IGenerator;
import ru.academyit.javacore.lesson8.homework.task.vehicle.generators.VehicleSeriesPartGenerator;

public class TestVehicleNumberPartGenerator {

    public static void test() {

        var gen = new VehicleSeriesPartGenerator();

        var res = gen.generate();
        System.out.println("TestVehicleNumberPartGenerator.test");
        System.out.println("result -> " + res);

        assert  res != null;

    }

}
