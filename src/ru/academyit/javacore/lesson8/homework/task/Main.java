package ru.academyit.javacore.lesson8.homework.task;

import ru.academyit.javacore.lesson8.homework.task.exceptions.FormatException;
import ru.academyit.javacore.lesson8.homework.task.exceptions.TaskCancelException;
import ru.academyit.javacore.lesson8.homework.task.tests.TesterUnit;
import ru.academyit.javacore.lesson8.homework.task.vehicle.VehicleNumber;
import ru.academyit.javacore.lesson8.homework.task.vehicle.generators.VehicleNumberGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    final static Map<String, Object> programContext = new HashMap<>();
    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static {
        programContext.put("repository", new GIBDDRepositoryImpl()); //TODO Поправить
    }


    public static void main(String[] args) throws IOException {

        if (Arrays.asList(args).contains("--test")) {
            TesterUnit.runTests(); // тестирование классов
        }

        GIBDDRepository repository = (GIBDDRepository) programContext.get("repository");

        while (true) {
            System.out.println("\nВнести новое транспортное средство? (Д)а/(Н)ет");
            String answer = reader.readLine();
            if (answer.isBlank()) {
                continue;
            } else if (answer.toUpperCase().charAt(0) == 'Н') {
                break;
            } else if (answer.toUpperCase().charAt(0) == 'Д') {
                var person = getPersonFromConsole();
                VehicleNumber vehicleNum;
                try {
                    vehicleNum = getVehicleNumberFromConsole();
                } catch (TaskCancelException e) {
                    continue;
                }
                var vehicle = repository.addVehicleNumber(vehicleNum, person);
                if (vehicle != null) {
                    System.out.println("Транспортное средство добавлено успешно.");
                    System.out.println("---\n" + vehicle + "\n---");
                }
            }
        }

//        var person = new Person("Иван", "Иванович", "Иванов");
//
//        System.out.println(repository.addVehicleNumber("Т652МХ790", person));

    }



    private static VehicleNumber getVehicleNumberFromConsole() throws IOException, TaskCancelException {
        System.out.println("Введите данные транспортного средства.");
        VehicleNumber vehicleNumber = null;
        System.out.print("Сгенерировать номер автотранспортного средства? +/-");
        char answer = reader.readLine().charAt(0);
        if (answer == '+') {
                vehicleNumber = new VehicleNumberGenerator().generate();
            System.out.println("Получен номер -> " + vehicleNumber);
        } else if (answer == '-') {
            while (vehicleNumber == null) {
                System.out.print("\tРегистрационный номер (Формат А000АА00 или А000АА000): ");
                String strNumber = reader.readLine();
                if ("-".equals(strNumber)) {
                    throw new TaskCancelException();
                }
                try {
                    vehicleNumber = VehicleNumber.valueOf(strNumber);
                } catch (FormatException e) {
                    System.out.println("Формат не верен! Введите снова или \"-\" для отмены операции.");
                }
            }
        }
        return vehicleNumber;
    }

    private static Person getPersonFromConsole() throws IOException {
        System.out.println("Введите данные владельца.");
        System.out.print("\tИмя: ");
        String fstName = reader.readLine();
        System.out.print("\tОтчество: ");
        String sndName = reader.readLine();
        System.out.print("\tФамилию: ");
        String lstName = reader.readLine();
        return new Person(fstName, sndName, lstName);
    }


}
