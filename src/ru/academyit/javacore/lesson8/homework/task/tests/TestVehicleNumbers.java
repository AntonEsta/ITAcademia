package ru.academyit.javacore.lesson8.homework.task.tests;

import ru.academyit.javacore.lesson8.homework.task.util.VehicleNumbers;

public class TestVehicleNumbers {

    public static void runAll() {
        testIsBeautifulNumber();
    }

    private static void testIsBeautifulNumber() {
        String number = "А777АА790";
        assert VehicleNumbers.isBeautifulNumber(number) : "TestVehicleNumbers.testIsBeautifulNumber работает не корректно!";
        number = "А734АА790";
        assert !VehicleNumbers.isBeautifulNumber(number) : "TestVehicleNumbers.testIsBeautifulNumber работает не корректно!";
        System.out.println("Метод VehicleNumbers.isBeautifulNumber() корректен.");
    }

}
