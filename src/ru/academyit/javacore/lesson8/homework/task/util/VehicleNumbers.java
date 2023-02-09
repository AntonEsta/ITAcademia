package ru.academyit.javacore.lesson8.homework.task.util;

import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumber;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VehicleNumbers {

    public static boolean isBeautifulNumber(String s) {
        if (s == null) {
            return false;
        }
        VehicleNumber number;
        try {
            number = VehicleNumber.valueOf(s);
        } catch (IllegalArgumentException e) {
            return false;
        }
        Set<String> numberSet = Stream.of(number.getNumber().getValue()).collect(Collectors.toSet());
        Set<String> seriesSet = Stream.of(number.getSeries().getValue()).collect(Collectors.toSet());
        return (numberSet.size() == 1) && (seriesSet.size() == 1);
    }

}
