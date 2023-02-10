package ru.academyit.javacore.lesson8.homework.task.repositories;

import ru.academyit.javacore.lesson8.homework.task.Person;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleDTO;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumber;

import java.util.List;

/**
 * Интерфейс репозитория АС ГИБДД.
 */
public interface GIBDDRepository {

    void addVehicleNumber(String s, Person p);

    VehicleDTO getVehicleByNumber(String s);

    List<VehicleNumber> getAllVehicleNumbers();

    VehicleDTO addVehicleNumber(VehicleNumber number, Person person);

    Person findPersonByNumber(String s);

    long getRecordsCount();

}
