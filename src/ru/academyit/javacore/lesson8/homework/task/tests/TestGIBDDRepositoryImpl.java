package ru.academyit.javacore.lesson8.homework.task.tests;

import ru.academyit.javacore.lesson8.homework.task.GIBDDRepository;
import ru.academyit.javacore.lesson8.homework.task.GIBDDRepositoryImpl;

public class TestGIBDDRepositoryImpl {


    private static final GIBDDRepository repository = new GIBDDRepositoryImpl();

    public static void test() {

        String s = "A034AA076";

        repository.addVehicleNumber(s);
        VehicleDTO dto = repository.getVehicleNumber(s);


    }

}
