package ru.academyit.javacore.lesson8.homework.task.tests;

import ru.academyit.javacore.lesson8.homework.task.repositories.GIBDDRepository;
import ru.academyit.javacore.lesson8.homework.task.repositories.GIBDDRepositoryImpl;
import ru.academyit.javacore.lesson8.homework.task.Person;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleDTO;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumber;
import ru.academyit.javacore.lesson8.homework.task.vehicle.generators.VehicleNumberGenerator;

public class TestGIBDDRepositoryImpl {
    private static final GIBDDRepository repository = new GIBDDRepositoryImpl();

    public static void runAll() {
        test();
//        testFindVehicleByNumber();
    }

    public static void test() {
        String s = "А034АА076";
        var person = new Person("Иван", "Иванович", "Иванов");
        repository.addVehicleNumber(s, person);
        VehicleDTO dto = repository.getVehicleByNumber(s);
        System.out.println(dto);
    }

    public static void testFindVehicleByNumber(GIBDDRepository repository) {
        var generator = new VehicleNumberGenerator();
        Person person;
        long checkCounter = 0;
        String genVehicleNumber;
        do {
            checkCounter++;
            System.out.print("\rПроверено " + checkCounter + " номеров");
            genVehicleNumber = generator.generate().toString();
            person = repository.findPersonByNumber(genVehicleNumber);
        } while (person == null);
        System.out.println("\nНайдено совпадение -> " + genVehicleNumber);
        System.out.println(new VehicleDTO(person, VehicleNumber.valueOf(genVehicleNumber)));
    }

    public static void testFindVehicleByNumber() {
        testFindVehicleByNumber(repository);
    }

}
