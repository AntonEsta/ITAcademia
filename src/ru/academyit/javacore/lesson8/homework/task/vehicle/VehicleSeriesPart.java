package ru.academyit.javacore.lesson8.homework.task.vehicle;

public class VehicleSeriesPart implements Comparable<VehicleSeriesPart> {

    public static final char[] VALID_USED_CHARACTERS = new char[]{'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
//    public static final char[] VALID_USED_CHARACTERS = new char[]{'A','B','E','K','M','H','O','P','C','T','Y','X','А','В','Е','К','М','Н','О','Р','С','Т','У','Х'};

    private final String value;

    private VehicleSeriesPart(String value) {
        this.value = value;
    }

    public static VehicleSeriesPart valueOf(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Номер не может быть null!");
        }

        if (!isValid(s)) {
            throw new IllegalArgumentException("Номер не отвечает требованиям!");
        }
        return new VehicleSeriesPart(s);
    }

    public static VehicleSeriesPart valueOf(CharSequence s) {
        if (s == null) {
            throw new IllegalArgumentException("Номер не может быть null!");
        }
        return valueOf(s.toString());
    }

    public static VehicleSeriesPart valueOf(char[] chars) {
        if (chars == null) {
            throw new IllegalArgumentException("Номер не может быть null!");
        }
        return valueOf(String.valueOf(chars));
    }

    public static VehicleSeriesPart parseSeries(String s) {

        s.toUpperCase()
        return valueOf();
    }

    @Override
    public int compareTo(VehicleSeriesPart o) {
        return value.compareTo(o.value);
    }

    private static boolean isValid(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (s.length() == 3) {
//            return s.toUpperCase().matches("^[ABEKMHOPCTYXАВЕКМНОРСТУХ]{3}");
            return s.toUpperCase().matches(String.format("^[%s]{3}", String.valueOf(VALID_USED_CHARACTERS)));
        }
        return false;
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

        VehicleSeriesPart that = (VehicleSeriesPart) o;

        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
