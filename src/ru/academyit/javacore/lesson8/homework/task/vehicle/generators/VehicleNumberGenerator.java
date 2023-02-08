package ru.academyit.javacore.lesson8.homework.task.vehicle.generators;

import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumber;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumberPart;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleRegionCodePart;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleSeriesPart;

public class VehicleNumberGenerator implements Generator<VehicleNumber> {

    private static final Generator vehicleRegionCodePartGenerator = new VehicleRegionCodePartGenerator();
    private static final Generator vehicleSeriesPartGenerator = new VehicleSeriesPartGenerator();
    private static final Generator vehicleNumberPartGenerator = new VehicleNumberPartGenerator();

    @Override
    public VehicleNumber generate() {
        VehicleSeriesPart series = (VehicleSeriesPart) vehicleSeriesPartGenerator.generate();
        VehicleNumberPart number = (VehicleNumberPart) vehicleNumberPartGenerator.generate();
        VehicleRegionCodePart code = (VehicleRegionCodePart) vehicleRegionCodePartGenerator.generate();
        return new VehicleNumber(series, number, code);
    }
}
