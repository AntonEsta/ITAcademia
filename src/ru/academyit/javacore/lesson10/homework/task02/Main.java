package ru.academyit.javacore.lesson10.homework.task02;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Result of doOldStyle()");
        doOldStyle();
        System.out.println();
        System.out.println("Result of doWithStreamAPI()");
        doWithStreamAPI();
    }

    static void doOldStyle() {
        int[] arr = {50, 60, 70, 80, 90, 100, 110, 120};
        int count = 0;
        for (int x : arr) {
            if (x >= 90) continue;
            x += 10;
            count++;
            if (count > 3) break;
            System.out.print(x);
        }
    }

    static void doWithStreamAPI() {
        int[] arr = {50, 60, 70, 80, 90, 100, 110, 120};
        Arrays.stream(arr).filter((x) -> x < 90).limit(3).map((x) -> x + 10).forEach(System.out::print);
    }

}
