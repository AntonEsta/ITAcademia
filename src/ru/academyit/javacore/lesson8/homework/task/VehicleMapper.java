package ru.academyit.javacore.lesson8.homework.task;

import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumber;

public class VehicleMapper {

    public static VehicleDTO toVehicleDTO(Person p, VehicleNumber n) {
        return new VehicleDTO(p, n);
    }

}
