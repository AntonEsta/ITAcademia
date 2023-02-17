package ru.academyit.javacore.lesson9.homework.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private final static int AERODROME_PARKING_CAPACITY = 5;
    private final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    static {
        Thread.setDefaultUncaughtExceptionHandler(
                (t, e) -> {
                    e.printStackTrace();
                    executorService.shutdownNow();
                    Runtime.getRuntime().exit(0);
                }
        );
    }

    public static void main(String[] args) throws IOException {

        var aerodrome = new AerodromeDispatcher("Аэродром \"Большие Васюки\"", AERODROME_PARKING_CAPACITY);

        System.out.println("Добропожаловать в симулятор аеродрома :)");

        System.out.println("Вместимость аэродрома состовляет " + AERODROME_PARKING_CAPACITY + " самолетов. Другим придется подождать в вохздухе." +
                " Надеемся у них хватит топлива!");

        System.out.println("\nДля начала попробуете ввести несколько самолетов, " +
                "которые уже кружат над аеродромом и просят принять их у себя.");

        for (boolean exit = false; !exit; ) {
            System.out.print("> ");
            switch (bufferedReader.readLine().trim().toLowerCase()) {
                case "l":
                case "landing":
                    Plane plane = getPlaneFromConsole();
                    if (!landingPlane(aerodrome, plane)) {
                        executorService.execute(new FlyEmulator(plane, aerodrome));
                    }
                    break;
                case "exitlast":
                case "el":
                    exitLastPlane(aerodrome);
                    break;
                case "exitall":
                case "ea":
                    exitLastAll(aerodrome);
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Команда не распознана!");
            }
        }
        executorService.shutdownNow();
    }

    private static void exitLastAll(AerodromeDispatcher aerodrome) {
        aerodrome.exitAllPlanes();
    }

    private static void exitLastPlane(AerodromeDispatcher aerodrome) {
        Plane plane = aerodrome.exitLastPlane();
        if (plane != null) {
            System.out.println(aerodrome.getTitle() + ". Выпущен борт №" + plane.getTitle());
        } else {
            System.out.println("Выпускать некого!");
        }
    }

    private static boolean landingPlane(AerodromeDispatcher aerodrome, Plane plane) {
        System.out.println("Принимаем борт " + plane.getNumber() + " " + plane.getTitle());
        if (aerodrome.landingPlane(plane)) {
            System.out.println("Борт " + plane.getNumber() + " " + plane.getTitle() + " принят.");
            return true;
        } else {
            System.out.println("Борт " + plane.getNumber() + " " + plane.getTitle() + " не принят.");
            return false;
        }
    }

    private static Plane getPlaneFromConsole() throws IOException {
        System.out.println("Введите данные борта для принятия...");
        System.out.print("\tИмя: ");
        var title = bufferedReader.readLine();
        System.out.print("\tНомер: ");
        int number = Integer.parseInt(bufferedReader.readLine());
        return new Plane(title, number);
    }

}
