package ru.academyit.javacore.lesson8.homework.task.tests;

import ru.academyit.javacore.lesson8.homework.task.GIBDDRepository;
import ru.academyit.javacore.lesson8.homework.task.GIBDDRepositoryImpl;
import ru.academyit.javacore.lesson8.homework.task.Person;
import ru.academyit.javacore.lesson8.homework.task.VehicleDTO;

public class TestGIBDDRepositoryImpl {
    private static final GIBDDRepository repository = new GIBDDRepositoryImpl();

    public static void test() {

        String s = "А034АА076";
        var person = new Person("Иван", "Иванович", "Иванов");
        repository.addVehicleNumber(s, person);
        VehicleDTO dto = repository.getVehicleByNumber(s);
        System.out.println(dto);
    }

}
