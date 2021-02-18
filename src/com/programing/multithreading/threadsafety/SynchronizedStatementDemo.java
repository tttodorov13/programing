package com.programing.multithreading.threadsafety;

/**
 * Thanks to: https://www.baeldung.com/java-thread-safety
 * <p>
 * Synchronization is expensive, so with this option, we
 * are able to only synchronize the relevant parts of a method.
 */
public class SynchronizedStatementDemo {

    private static int counter = 0;

    public static void main(String[] args) {
        SynchronizedStatementDemo synchronizedStatementDemo =
                new SynchronizedStatementDemo();

        for (int i = 0; i < 5; i++) {
            synchronizedStatementDemo.incrementCounter();
            System.out.println(synchronizedStatementDemo.getCounter());
        }
    }

    public void incrementCounter() {
        synchronized (this) {
            counter += 1;
        }

        // additional unsynced operations
        System.out.println(getCounter());
    }

    public int getCounter() {
        return counter;
    }
}
