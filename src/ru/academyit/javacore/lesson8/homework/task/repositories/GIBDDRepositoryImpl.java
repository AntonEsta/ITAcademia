package ru.academyit.javacore.lesson8.homework.task.repositories;

import ru.academyit.javacore.lesson8.homework.task.Person;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleDTO;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleMapper;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumber;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GIBDDRepositoryImpl implements GIBDDRepository {

    private final Map<VehicleNumber, Person> data = new ConcurrentHashMap<>();

    @Override
    public void addVehicleNumber(String s, Person p) {
        addVehicleNumber(VehicleNumber.valueOf(s), p);
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

    @Override
    public Person findPersonByNumber(String s) {
        if (s == null) {
            return null;
        }
        var number = VehicleNumber.valueOf(s);
        return data.get(number);
    }

    @Override
    public long getRecordsCount() {
        return data.size();
    }

}
