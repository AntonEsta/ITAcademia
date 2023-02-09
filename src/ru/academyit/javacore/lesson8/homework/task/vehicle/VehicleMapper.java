package ru.academyit.javacore.lesson8.homework.task.vehicle;

import ru.academyit.javacore.lesson8.homework.task.Person;

public class VehicleMapper {

    public static VehicleDTO toVehicleDTO(Person p, VehicleNumber n) {
        return new VehicleDTO(p, n);
    }

}
