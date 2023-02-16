package ru.academyit.javacore.lesson9.homework.task01.util;

import java.io.IOException;

public abstract class Generator<T> {
    public abstract T generate() throws IOException;
}
