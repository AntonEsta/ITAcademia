package ru.academyit.javacore.lesson9.homework.task02;

import java.util.*;

public class PlanesParking {

    private final int parkingCapacity;
    private final Deque<Plane> parking;

    /**
     * Конструктор
     * @param capacity количество мест на парковке
     */
    public PlanesParking(int capacity) {
        parkingCapacity = capacity;
        parking = new ArrayDeque<>(parkingCapacity);
    }


    /**
     * Добавляет элемент
     * @param plane самолет который нужно добавить на парковку
     */
    public boolean add(Plane plane) {
        if (parking.size() < parkingCapacity) {
            return parking.add(plane);
        }
        return false;
    }

    /**
     * Получить ппоследний прибывший самолет со стоянки (в очереди) с удаление его со стоянки (очереди)
     */
    public Plane exitLast() {
        return parking.pollLast();
    }

    /**
     * Возвращает количество свободных мест на парковке.
     * @return кол-во свободных мест.
     */
    public int getFreePlacesCount() {
        return parkingCapacity - parking.size();
    }

    /**
     * Удалить всё из очереди.
     */
    public void exitAll() {
        for (Plane p = parking.pollLast(); p != null; p = parking.pollLast()) {
            System.out.println("Самолёт №" + p.getNumber() + " " + p.getTitle() + " покинул парковку.");
        }
        if (parking.isEmpty()) {
            System.out.println("Парковка пуста!");
        }
    }

}
