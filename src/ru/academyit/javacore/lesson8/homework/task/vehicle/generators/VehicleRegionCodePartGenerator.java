package ru.academyit.javacore.lesson8.homework.task.vehicle.generators;

import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleRegionCodePart;

public class VehicleRegionCodePartGenerator extends Generator<VehicleRegionCodePart> {
    @Override
    public VehicleRegionCodePart generate() {
        return VehicleRegionCodePart.valueOf(Math.random() * 999);
    }
}
