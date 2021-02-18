package com.programing.multithreading;

/**
 * Thanks to https://www.baeldung.com/java-thread-yield
 *
 * As the official documentation suggests, yield() provides
 * a mechanism to inform the “scheduler” that the current
 * thread is willing to relinquish its current use of processor
 * but it'd like to be scheduled back soon as possible.
 *
 * The “scheduler” is free to adhere or ignore this information
 * and in fact, has varying behavior depending upon the operating system.
 *
 * The following code fragment displays two threads at same
 * priority yielding after each schedule:
 */
public class ThreadYield {
    public static void main(String[] args) {
        Runnable r = () -> {
            int counter = 0;
            while (counter < 2) {
                System.out.println(Thread.currentThread()
                        .getName());
                counter++;
                Thread.yield();
            }
        };
        new Thread(r).start();
        new Thread(r).start();
    }
}
