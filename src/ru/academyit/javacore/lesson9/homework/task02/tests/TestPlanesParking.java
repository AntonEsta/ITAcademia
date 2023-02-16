package ru.academyit.javacore.lesson9.homework.task02.tests;

import ru.academyit.javacore.lesson9.homework.task02.Plane;
import ru.academyit.javacore.lesson9.homework.task02.PlanesParking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class TestPlanesParking {

    public static void runAll() {
        testAddMethod();
        testExitLastMethod();
        testExitAllMethod();
    }

    private static void testAddMethod() {
        var parking = new PlanesParking(5);
        parking.add(new Plane("New Plane", 1902));
        assert parking.getFreePlacesCount() == 4 : "Самолёт не добавлен!" ;
        System.out.println("TestPlanesParking.testAddMethod complete!");
    }

    private static void testExitLastMethod() {
        var parking = new PlanesParking(5);
        var inPlane = getRandomPlane();
        var inPlane2 = getRandomPlane();
        parking.add(inPlane);
        parking.add(inPlane2);
        var outPlane = parking.exitLast();
        assert outPlane.equals(inPlane2) : "Самолёт был добавлен, но вернулся другой!" ;
        System.out.println("TestPlanesParking.testExitLastMethod complete!");
    }

    private static void testExitAllMethod() {
        var parking = new PlanesParking(5);
        var list = new ArrayList<Plane>(5);
        Collections.addAll(list,
                getRandomPlane(),
                getRandomPlane(),
                getRandomPlane(),
                getRandomPlane(),
                getRandomPlane(),
                getRandomPlane());

        list.forEach((i)->{
            parking.add(i);
            System.out.println(i);
        });

        parking.exitAll();
        System.out.println("TestPlanesParking.testExitAllMethod complete!");
    }

    private static Plane getRandomPlane() {
        return new Plane(UUID.randomUUID().toString(), (int) (Math.random() * 100));
    }

}
