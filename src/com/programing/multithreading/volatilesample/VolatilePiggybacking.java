package com.programing.multithreading.volatilesample;

/**
 * Thanks to https://www.baeldung.com/java-volatile
 *
 * Because of the strength of the happens-before
 * memory ordering, sometimes we can piggyback on
 * the visibility properties of another volatile variable.
 * For instance, in our particular example, we just need
 * to mark the ready variable as volatile:
 *
 * Anything prior to writing true to the ready variable
 * is visible to anything after reading the ready variable.
 * Therefore, the number variable piggybacks on the memory
 * visibility enforced by the ready variable. Put simply,
 * even though it's not a volatile variable,
 * it is exhibiting a volatile behavior.
 *
 * By making use of these semantics, we can define only
 * a few of the variables in our class as volatile and
 * optimize the visibility guarantee.
 */
public class VolatilePiggybacking {

    private static int number; // not volatile
    private volatile static boolean ready;

    private static class Reader extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }

            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new VolatilePiggybacking.Reader().start();
        number = 42;
        ready = true;
    }
}
