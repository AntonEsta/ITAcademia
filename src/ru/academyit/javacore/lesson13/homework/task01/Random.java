package ru.academyit.javacore.lesson13.homework.task01;

/**
 * Random value generation class.
 */
public class Random {

    private final int start;
    private final int end;

    public Random(int start, int end) {
        if (start < end) {
            this.start = start;
            this.end = end;
        } else {
            this.start = end;
            this.end = start;
        }
    }

    /**
     * Returns randomized integer number.
     *
     * @return random integer value.
     */
    public int nextInt() {
        long mul = 0x5DEECE66DL;
        int rndNum;
        do {
            rndNum = (int) (System.nanoTime() * mul) >> getZeroBitsCount(end);
        } while ((rndNum >= end) || (rndNum <= start));
        return rndNum;
    }

    /**
     * Calculating the number of zero-bits from start.
     *
     * @param number Number to analyze.
     * @return Number of bits used.
     */
    private static short getZeroBitsCount(int number) {
        short bit = 32;
        while (number != 0) {
            number >>= 1;
            bit--;
        }
        return --bit;
    }

}

