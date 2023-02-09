package ru.academyit.javacore.lesson8.homework.task.vehicle.generators;

import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumberPart;

public class VehicleNumberPartGenerator extends Generator<VehicleNumberPart> {
    @Override
    public VehicleNumberPart generate() {
        return VehicleNumberPart.valueOf(Math.random() * 999);
    }
}
