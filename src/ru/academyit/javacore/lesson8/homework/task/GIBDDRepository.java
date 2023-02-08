package ru.academyit.javacore.lesson8.homework.task;

import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumber;

public interface GIBDDRepository {

    boolean addVehicleNumber(VehicleNumber number);

    boolean addVehicleNumber(String s, Person p);

    VehicleDTO getVehicleByNumber(String s);

}
