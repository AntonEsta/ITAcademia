package ru.academyit.javacore.lesson8.homework.task.util;

import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumber;

import java.util.*;
import java.util.stream.Collectors;

public class VehicleNumbers {

    /**
     * Проверяет номер на соответствие "красивому" номеру
     *
     * @param s номер автотранспортного средства
     * @return {@code true} если соответствует, {@code false} - не соответствует или номер не корректен.
     */
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

        Set<?> numberSet = number.getNumber().getValue().chars().boxed().collect(Collectors.toSet());
        Set<?> seriesSet = number.getSeries().getValue().chars().boxed().collect(Collectors.toSet());
        return (numberSet.size() == 1) && (seriesSet.size() == 1);
    }

    public static List<VehicleNumber> filterBeautifulNumbers(List<VehicleNumber> list) {
        return list.stream().filter(n -> isBeautifulNumber(n.toString())).collect(Collectors.toList());
    }

}
