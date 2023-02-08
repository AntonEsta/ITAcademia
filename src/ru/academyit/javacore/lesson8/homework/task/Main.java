package ru.academyit.javacore.lesson8.homework.task;

import ru.academyit.javacore.lesson8.homework.task.tests.TesterUnit;

import java.util.HashMap;
import java.util.Map;

public class Main {

    final static Map<String, Object> programContext = new HashMap<>();

    static {
        programContext.put("repository", new GIBDDRepositoryImpl()); //TODO Поправить
    }


    public static void main(String[] args) {

        TesterUnit.runTests(); // тестирование классов

        GIBDDRepository repository = (GIBDDRepository) programContext.get("repository");

        var person = new Person("Иван", "Иванович", "Иванов");

        repository.addVehicleNumber("Т652МХ790", person);

    }



}
