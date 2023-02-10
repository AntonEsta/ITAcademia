package ru.academyit.javacore.lesson8.homework.task.vehicle;

import ru.academyit.javacore.lesson8.homework.task.exceptions.FormatException;

import java.util.Objects;

public class VehicleNumber {

    private final VehicleSeriesPart seriesPart;
    private final VehicleNumberPart numberPart;
    private final VehicleRegionCodePart regionCodePart;

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

    public static boolean isValid(String s) {
//        return s.toUpperCase().matches(String.format("^[%s][\\d]{3}[%s]{2}[\\d]{3}$", String.valueOf(VehicleSeriesPart.VALID_USED_CHARACTERS)));
        return s.toUpperCase().matches(
                "^[" +
                        String.valueOf(VehicleSeriesPart.VALID_USED_CHARACTERS) +
                        "][\\d]{3}[" +
                        String.valueOf(VehicleSeriesPart.VALID_USED_CHARACTERS) +
                        "]{2}[\\d]{2,3}$");
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

    public VehicleSeriesPart getSeries() {
        return seriesPart;
    }

    public VehicleNumberPart getNumber() {
        return numberPart;
    }

    @Override
    public String toString() {
        return String.valueOf(seriesPart.getValue().charAt(0)) +
                numberPart +
                seriesPart.getValue().substring(1) +
                regionCodePart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleNumber that = (VehicleNumber) o;
        return seriesPart.equals(that.seriesPart) && numberPart.equals(that.numberPart) && regionCodePart.equals(that.regionCodePart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriesPart, numberPart, regionCodePart);
    }
}
