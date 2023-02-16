package ru.academyit.javacore.lesson9.homework.task02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class FlyEmulator implements Emulator, Runnable {

    private final String messagePrefix;
    private Plane plane;
    private final AerodromeDispatcher aerodrome;

    public FlyEmulator(Plane plane, AerodromeDispatcher aerodromeDispatcher) {
        this.plane = plane;
        this.messagePrefix = "Говорит борт " + plane.getNumber() + ". ";
        this.aerodrome = aerodromeDispatcher;
    }

    /**
     * Уменшает уровень топлива в самолете на определенную часть.
     * @param portion часть для уменьшения.
     */
    public void reduceFuelLevel(double portion) {
        if (portion > 100) {
            throw new IllegalArgumentException("Portion can't be more then 100%.");
        }
        if (portion < 0) {
            portion = 0;
        }
        plane.setFuelLevel(plane.getFuelLevel() - portion);
    }

    public boolean requestBoarding() {
        return aerodrome.landingPlane(plane);
    }

    @Override
    public void run() {
        emulate();
    }


    /**
     * Эмуляция полета самолета
     */
    @Override
    public void emulate() {
        while (Objects.nonNull(plane)) {
            if (requestBoarding()) {
                System.out.println(getFormatMessage("Ура! Нас приняли!"));
                plane = null;
            } else {
                System.out.print(getFormatMessage(String.format("В приземлении отказано! Уровень топлива: %.0f", plane.getFuelLevel())));
                System.out.println(" Продолжаем полёт.");
                reduceFuelLevel(Math.random());
                checkFuelLevel();
            }
            try {
                sleep((long) (Math.random() * 10_000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Проверяет уровень топлива у самолёта и выводит соостветствующее сообщение.
     */
    private void checkFuelLevel() {
        if (plane.getFuelLevel() < 10) {
            System.out.println(getFormatMessage("Внимание топливо на исходе!"));
        }
        if (plane.getFuelLevel() < 1) {
            System.out.println(getFormatMessage("Внимание уровень топлива критически низок! Прощайте!"));
        }

        if (plane.getFuelLevel() <= 0) {
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("d.M.y h:m:s")) + " БОРТ " + plane.getNumber() + " РАЗБИЛСЯ!!!");
            destroyPlane();
        }
    }

    /**
     * Удаляет самолет
     */
    private void destroyPlane() {
        plane = null;
    }

    /**
     * Составляет сообщение по образцу.
     * @param message сообщение.
     * @return Строка отформатированного сообщения.
     */
    private String getFormatMessage(String message) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("d.M.y h:m:s")) + " " + messagePrefix + message;
    }

}
