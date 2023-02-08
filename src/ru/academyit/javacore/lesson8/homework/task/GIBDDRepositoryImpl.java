package ru.academyit.javacore.lesson8.homework.task;

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
    public boolean addVehicleNumber(String s, Person p) {
        return data.putIfAbsent(VehicleNumber.valueOf(s), p) != null;
    }

    @Override
    public VehicleDTO getVehicleByNumber(String s) {
        data.get(VehicleNumber.valueOf(s));
        return null;
    }


}
