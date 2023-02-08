package ru.academyit.javacore.lesson8.homework.task;

import ru.academyit.javacore.lesson8.homework.task.tests.VehicleDTO;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumber;

import java.util.HashMap;
import java.util.Map;

public class GIBDDRepositoryImpl implements GIBDDRepository {

    private final Map<VehicleNumber, Person> data = new HashMap<>();

    @Override
    public boolean addVehicleNumber(VehicleNumber number) {
        return false;
    }

    @Override
    public boolean addVehicleNumber(String s) {
        return false;
    }

    @Override
    public VehicleDTO getVehicleNumber(String s) {
        data.get(new VehicleNumber.valueOf(s));
        return null;
    }


}
