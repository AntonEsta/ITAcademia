package ru.left;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class MyСonsole {

    private final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    private static boolean canWrite = true;

    public static void main(String[] args) throws IOException {

        Executors.newSingleThreadExecutor().execute(()->{
            int i = 0;
            while(true) {
                try {
                    println(i + " Hello!");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                i++;
            }
        });
//        println("Hello!");
        while (true) {
            var s = readln();
//            var s = new Scanner(System.in);
            System.out.println(s);
        }


    }

    public static void println(String s) throws IOException {
        bufferedWriter.write(s + "\n");
        flushWriter();

    }

    private static void flushWriter() throws IOException {
        if (canWrite) {
            System.out.println("flush");
            bufferedWriter.flush();
        }
    }

    public static String readln() throws IOException {
        var s = "";
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            canWrite = false;
            System.out.println("canWrite is false.");
            s += scanner.nextByte();
        }

//        if (!canWrite && Character.isSpaceChar(ch)) {
//            canWrite = false;
//            System.out.println("canWrite is false.");
//        } else {
//            s += ch;
//        }
//        s += bufferedReader.readLine();

        if (!canWrite) {
            canWrite = true;
            System.out.println("canWrite is true.");
        }
        flushWriter();
        return s;
    }

}
