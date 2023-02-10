package ru.academyit.javacore.lesson8.homework.task;

import ru.academyit.javacore.lesson8.homework.task.exceptions.FormatException;
import ru.academyit.javacore.lesson8.homework.task.exceptions.TaskCancelException;
import ru.academyit.javacore.lesson8.homework.task.repositories.GIBDDRepository;
import ru.academyit.javacore.lesson8.homework.task.repositories.GIBDDRepositoryImpl;
import ru.academyit.javacore.lesson8.homework.task.tests.TestGIBDDRepositoryImpl;
import ru.academyit.javacore.lesson8.homework.task.tests.TesterUnit;
import ru.academyit.javacore.lesson8.homework.task.util.VehicleNumbers;
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
    final static VehicleNumberGenerator generator = new VehicleNumberGenerator();

    static {
        programContext.put("repository", new GIBDDRepositoryImpl());
    }

    public static void main(String[] args) throws IOException {

        // тестируем методы классов
        if (Arrays.asList(args).contains("--test")) {
            TesterUnit.runTests(); // тестирование классов
        }

        // получаем нужный репозиторий из "конфигурации программы"
        GIBDDRepository repository = (GIBDDRepositoryImpl) programContext.get("repository");

        // заполняем репозиторий тестовыми данными
        fillRepositoryByTestData(repository, 100_000);

        // тест на поиск владельца авто по номеру машины
        TestGIBDDRepositoryImpl.testFindVehicleByNumber(repository);

        showBeautifulNumbersFromRepository(repository);


        // внесение данных в репозиторий
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
    }

    private static void showBeautifulNumbersFromRepository(GIBDDRepository repository) {
        var list = VehicleNumbers.filterBeautifulNumbers(repository.getAllVehicleNumbers());
        System.out.println("\nКрасивые номера зарегистрированные в базе:");
        for (VehicleNumber number : list) {
            System.out.println("\t" + number);
        }
    }

    /**
     * Заполняет репозиторий тестовыми данными.
     * Номер транспортного средства генерируется автоматически.
     * ФИО владелеца генерируется по шаблону ("Noname" + IntRandom).
     *
     * @param repository  репозиторий для заполнения
     * @param recordCount количество записей для внесения
     */
    private static void fillRepositoryByTestData(GIBDDRepository repository, int recordCount) {
        System.out.println("Заполнение хранилища тестовыми данными...");
        for (int i = 1; i < recordCount + 1; i++) {
            System.out.print("\rВнесено " + i + " записи(ей) из " + recordCount);
            var dto = repository.addVehicleNumber(
                    generator.generate(),
                    new Person("Noname" + (int) (Math.random() * 10), "Noname" + (int) (Math.random() * 10), "Noname" + (int) (Math.random() * 10)));
            if (dto == null) {
                i--;
            }
        }
        System.out.println("\nЗавершено!");
        System.out.println("Сейчас хранилище содержит " + repository.getRecordsCount() + " записи(ей).");
    }


    /**
     * Получает номер транспортного средства с консоли.
     *
     * @return Объект-Номер транспортного средства.
     * @throws IOException
     * @throws TaskCancelException
     */
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

    /**
     * Получает данные владельца с консоли.
     *
     * @return
     * @throws IOException
     */
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
