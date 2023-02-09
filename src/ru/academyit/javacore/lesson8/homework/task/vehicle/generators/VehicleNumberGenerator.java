package ru.academyit.javacore.lesson8.homework.task.vehicle.generators;

import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumber;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumberPart;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleRegionCodePart;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleSeriesPart;

public class VehicleNumberGenerator extends Generator<VehicleNumber> {

    private static final Generator<VehicleRegionCodePart> vehicleRegionCodePartGenerator = new VehicleRegionCodePartGenerator();
    private static final Generator<VehicleSeriesPart> vehicleSeriesPartGenerator = new VehicleSeriesPartGenerator();
    private static final Generator<VehicleNumberPart> vehicleNumberPartGenerator = new VehicleNumberPartGenerator();

    @Override
    public VehicleNumber generate() {
        VehicleSeriesPart series = vehicleSeriesPartGenerator.generate();
        VehicleNumberPart number = vehicleNumberPartGenerator.generate();
        VehicleRegionCodePart code = vehicleRegionCodePartGenerator.generate();
        return new VehicleNumber(series, number, code);
    }
}
