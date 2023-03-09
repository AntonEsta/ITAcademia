package ru.academyit.javacore.lesson14.homework.task01;

public class Main {
    public static void main(String[] args) {
        var array = new int[]{1,3,5,2,6,4,7,8,9,5,6,7,23,34,45,56,75,245,4,1};
        System.out.println("\nИсходный массив (" + array.length + " элементов): " + java.util.Arrays.toString(array));
        array = Arrays.sort(array);
        System.out.println("\nСортированный массив: " + java.util.Arrays.toString(array));

        // сгенерировать массив
        Random random = new Random(1, 100);
        var arr = new int[1000];
        for (int i=0; i<arr.length; i++) {
            arr[i] = random.nextInt();
        }

        System.out.println("\nИсходный массив (" + arr.length + " элементов): " + java.util.Arrays.toString(arr));
        arr = Arrays.sort(arr);
        System.out.println("\nСортированный массив: " + java.util.Arrays.toString(arr));
    }
}
