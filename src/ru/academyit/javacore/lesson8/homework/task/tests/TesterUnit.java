package ru.academyit.javacore.lesson8.homework.task.tests;

import ru.academyit.javacore.lesson8.homework.task.tests.generators.TestVehicleNumberPartGenerator;
import ru.academyit.javacore.lesson8.homework.task.tests.generators.TestVehicleRegionCodePartGenerator;
import ru.academyit.javacore.lesson8.homework.task.tests.generators.TestVehicleSeriesPartGenerator;

public final class TesterUnit {

    public static void runTests() {

        // тест Vehicle Parts
        TestVehicleNumberPart.runAll();
        TestVehicleSeriesPart.runAll();
        TestVehicleRegionCodePart.runAll();

        // тест Generators
        TestVehicleSeriesPartGenerator.test();
        TestVehicleNumberPartGenerator.test();
        TestVehicleRegionCodePartGenerator.test();

        // тест Vehicle Number
        TestVehicleNumber.runAll();

        // repository test
        TestGIBDDRepositoryImpl.test();

        System.out.println("Тесты пройдены!");
    }

}
