package ru.academyit.javacore.lesson8.homework.task.vehicle;

import ru.academyit.javacore.lesson8.homework.task.exceptions.FormatException;

import java.text.Format;
import java.util.regex.Pattern;

public class VehicleNumber {

    private VehicleSeriesPart seriesPart;
    private VehicleNumberPart numberPart;
    private VehicleRegionCodePart regionCodePart;

    public VehicleNumber(VehicleSeriesPart seriesPart, VehicleNumberPart numberPart, VehicleRegionCodePart regionCodePart) {
        this.seriesPart = seriesPart;
        this.numberPart = numberPart;
        this.regionCodePart = regionCodePart;
    }

    public static VehicleNumber valueOf(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Параметр не может быть null!");
        }
        if (!isValid(s)) {
            throw new FormatException("Не верный формат данных!");
        }
        var seriesPart = VehicleSeriesPart.parseSeries(s);
        var numberPart = VehicleNumberPart.parseNumber(s);
        var regionCodePart = VehicleRegionCodePart.parseRegionCode(s);
        return new VehicleNumber(seriesPart, numberPart, regionCodePart);
    }

    private static boolean isValid(String s) {
//        return s.toUpperCase().matches(String.format("^[%s][\\d]{3}[%s]{2}[\\d]{3}$", String.valueOf(VehicleSeriesPart.VALID_USED_CHARACTERS)));
        return s.toUpperCase().matches(
              new StringBuilder()
                        .append("^[")
                        .append(String.valueOf(VehicleSeriesPart.VALID_USED_CHARACTERS))
                        .append("][\\d]{3}[")
                        .append(String.valueOf(VehicleSeriesPart.VALID_USED_CHARACTERS))
                        .append("]{2}[\\d]{2,3}$")
                        .toString());
//        ^[АВЕКМНОРСТУХ][\d]{3}[АВЕКМНОРСТУХ]{2}[\d]{2,3}$

        //for debug
//        System.out.print("VehicleNumber.isValid: ");
//        System.out.println(s.toUpperCase().matches("^[АВЕКМНОРСТУХ][\\d]{3}[АВЕКМНОРСТУХ]{2}[\\d]{2,3}$"));
//        var matcher = Pattern.compile(
//                new StringBuilder()
//                        .append("^[")
//                        .append(String.valueOf(VehicleSeriesPart.VALID_USED_CHARACTERS))
//                        .append("][\\d]{3}[")
//                        .append(String.valueOf(VehicleSeriesPart.VALID_USED_CHARACTERS))
//                        .append("]{2}[\\d]{2,3}$")
//                        .toString())
//                .matcher(s);
//        return matcher.find();
//        return s.toUpperCase().matches("^[АВЕКМНОРСТУХ][\\d]{3}[АВЕКМНОРСТУХ]{2}[\\d]{2,3}$");
    }

    @Override
    public String toString() {
        return String.valueOf(seriesPart.getValue().charAt(0)) +
                numberPart +
                seriesPart.getValue().substring(1) +
                regionCodePart;
    }

}
