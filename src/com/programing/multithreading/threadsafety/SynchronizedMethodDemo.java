package com.programing.multithreading.threadsafety;

/**
 * Thanks to: https://www.baeldung.com/java-thread-safety
 * <p>
 * Simply put, only one thread can access a synchronized
 * method at a time while blocking access to this method
 * from other threads. Other threads will remain blocked
 * until the first thread finishes or the method throws
 * an exception.
 * <p>
 * We can create a thread-safe version of incrementCounter()
 * in another way by making it a synchronized method.
 * <p>
 * Synchronized methods rely on the use of “intrinsic locks”
 * or “monitor locks”.
 * <p>
 * When a thread calls a synchronized method, it acquires the
 * intrinsic lock.
 */
public class SynchronizedMethodDemo {

    private static int counter = 0;

    public static void main(String[] args) {
        SynchronizedMethodDemo synchronizedMethodDemo =
                new SynchronizedMethodDemo();

        for (int i = 0; i < 5; i++) {
            synchronizedMethodDemo.incrementCounter();
            System.out.println(synchronizedMethodDemo.getCounter());
        }
    }

    public synchronized void incrementCounter() {
        counter += 1;
    }

    public int getCounter() {
        return counter;
    }
}
