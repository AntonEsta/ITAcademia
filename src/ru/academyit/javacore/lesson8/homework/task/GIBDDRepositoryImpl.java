package ru.academyit.javacore.lesson8.homework.task;

import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GIBDDRepositoryImpl implements GIBDDRepository {

    private final Map<VehicleNumber, Person> data = new ConcurrentHashMap<>();

    @Override
    public boolean addVehicleNumber(VehicleNumber number) {
        return false;
    }

    @Override
    public boolean addVehicleNumber(String s, Person p) {
        return addVehicleNumber(VehicleNumber.valueOf(s), p) != null;
    }

    @Override
    public VehicleDTO getVehicleByNumber(String s) {
        data.get(VehicleNumber.valueOf(s));
        return null;
    }

    @Override
    public VehicleDTO addVehicleNumber(VehicleNumber n, Person p) {
        data.putIfAbsent(n, p);
        if (data.get(n).equals(p)) {
            return VehicleMapper.toVehicleDTO(p, n);
        }
        return null;
    }

}
