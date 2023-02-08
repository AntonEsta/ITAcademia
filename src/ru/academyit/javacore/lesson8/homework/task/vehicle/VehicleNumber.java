package ru.academyit.javacore.lesson8.homework.task.vehicle;

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
            throw new IllegalArgumentException();
        }
        VehicleSeriesPart seriesPart = VehicleSeriesPart.parseSeries(s);
        return new VehicleNumber();
    }

    private static boolean isValid(String s) {
        return s.toUpperCase().matches(String.format("^[%s][\\d]{3}[%s]{2}[\\d]{3}$", String.valueOf(VehicleSeriesPart.VALID_USED_CHARACTERS)));
    }

    @Override
    public String toString() {
        return String.valueOf(seriesPart.getValue().charAt(0)) +
                numberPart +
                regionCodePart.getValue().substring(1);

    }

}
