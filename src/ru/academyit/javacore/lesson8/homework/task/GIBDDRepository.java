package ru.academyit.javacore.lesson8.homework.task;

import ru.academyit.javacore.lesson8.homework.task.tests.VehicleDTO;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumber;

public interface GIBDDRepository {

    boolean addVehicleNumber(VehicleNumber number);

    boolean addVehicleNumber(String s);

    VehicleDTO getVehicleNumber(String s);

}
