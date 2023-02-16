package ru.academyit.javacore.lesson9.homework.task01.util;

import ru.academyit.javacore.lesson9.homework.task01.Main;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Resources {

    public static Path getResourcePath(String filename) throws URISyntaxException {
        URL url = Main.class.getClassLoader().getResource(filename);
        assert url != null;
        return Paths.get(url.toURI());
    }

}
