package ru.academyit.javacore.lesson9.homework.task01.util;

import ru.academyit.javacore.lesson9.homework.task01.Person;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.List;

import static ru.academyit.javacore.lesson9.homework.task01.util.Resources.getResourcePath;

public class PersonGenerator extends Generator<Person> {

    @Override
    public Person generate() {

        String fstName;
        String sndName;
        String lstName;
        try {
            fstName = getRandomLineFromResourceFile("male_names_rus.txt");
            sndName = getRandomLineFromResourceFile("male_names_rus.txt").concat("ович"); // грубо! нужен отдельный алгоритм
            lstName = getRandomLineFromResourceFile("male_surnames_rus.txt");
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return new Person(fstName, sndName, lstName);
    }

    private static String getRandomLineFromResourceFile(String filename) throws IOException, URISyntaxException {
        List<String> list = Files.readAllLines(getResourcePath(filename));
        String s = list.get((int) (Math.random() * list.size()));
        list.clear();
        return s;
    }

}
