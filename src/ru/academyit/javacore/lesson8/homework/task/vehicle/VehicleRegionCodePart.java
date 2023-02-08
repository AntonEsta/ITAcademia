package ru.academyit.javacore.lesson8.homework.task.vehicle;

public class VehicleRegionCodePart implements Comparable<VehicleRegionCodePart>{

    private final String value;

    private VehicleRegionCodePart(String value) {
        this.value = value;
    }

    public static VehicleRegionCodePart valueOf(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Номер не может быть null!");
        }
        if (!isValid(s)) {
            throw new IllegalArgumentException("Номер не отвечает требованиям!");
        }
        return new VehicleRegionCodePart(s);
    }

    public static VehicleRegionCodePart valueOf(Number n) {
        if (n == null) {
            throw new IllegalArgumentException("Номер не может быть null!");
        }
        return valueOf(String.format("%03d", n.intValue()));
    }

    private static boolean isValid(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (s.length() == 3) {
            return s.matches("^\\d{3}");
        }
        return false;
    }

    @Override
    public int compareTo(VehicleRegionCodePart o) {
        return this.value.compareTo(o.value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleRegionCodePart that = (VehicleRegionCodePart) o;

        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
