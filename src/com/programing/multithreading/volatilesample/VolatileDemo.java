package com.programing.multithreading.volatilesample;

/**
 * Thanks to: https://www.baeldung.com/java-volatile
 *
 * To ensure that updates to variables propagate
 * predictably to other threads, we should apply
 * the volatile modifier to those variables.
 *
 * This way, we communicate with runtime and
 * processor to not reorder any instruction
 * involving the volatile variable. Also,
 * processors understand that they should
 * flush any updates to these variables right away.
 */
public class VolatileDemo {

    private volatile static int number;
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
        new VolatileDemo.Reader().start();
        number = 42;
        ready = true;
    }
}
