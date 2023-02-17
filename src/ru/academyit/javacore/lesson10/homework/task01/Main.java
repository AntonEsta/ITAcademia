package ru.academyit.javacore.lesson10.homework.task01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Collection<Integer> sourceList = new ArrayList<>();
        Collections.addAll(sourceList, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 7, 4, 2);
        System.out.println(sourceList);
        Collection<Integer> endList = sourceList.stream().distinct().map((i) -> i * i).collect(Collectors.toList());
        System.out.println(endList);
    }

}
