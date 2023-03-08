package ru.academyit.javacore.lesson13.homework.task01;

public class Main {
    public static void main(String[] args) {
        var array = Arrays.sort(new int[]{1,3,5,2,6,4,7,8,9,5,6,7,23,34,45,56,75,245,4,1});
        System.out.println(java.util.Arrays.toString(array));
        Random random = new Random(0, 100);
        var arr = new int[1_000_000];
        for (int i=0; i<arr.length; i++) {
            arr[i] = random.nextInt();
        }
        System.out.println(java.util.Arrays.toString(java.util.Arrays.stream(Arrays.sort(arr)).distinct().toArray()));


    }
}
