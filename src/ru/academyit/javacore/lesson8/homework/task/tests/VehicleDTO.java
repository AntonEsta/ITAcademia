package ru.academyit.javacore.lesson8.homework.task.tests;

import ru.academyit.javacore.lesson6.homework.task.Person;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumber;

public class VehicleDTO {
    private final Person person;
    private final VehicleNumber vehicleNumber;

    public VehicleDTO(Person person, VehicleNumber vehicleNumber) {
        this.person = person;
        this.vehicleNumber = vehicleNumber;
    }


}
