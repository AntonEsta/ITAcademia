package ru.academyit.javacore.lesson8.homework.task.vehicle.generators;

import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleSeriesPart;

public class VehicleSeriesPartGenerator extends Generator<VehicleSeriesPart> {

    @Override
    public VehicleSeriesPart generate() {
        StringBuilder builder = new StringBuilder();
        while (builder.length() < 3) {
            builder.append(VehicleSeriesPart.VALID_USED_CHARACTERS[(int) (Math.random() * VehicleSeriesPart.VALID_USED_CHARACTERS.length)]);
        }
        return VehicleSeriesPart.valueOf(builder.toString());
    }
}
