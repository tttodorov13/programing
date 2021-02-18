package com.programing.multithreading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thanks to: https://www.tutorialspoint.com/java_concurrency/concurrency_atomic_integer.htm
 */
public class AtomicIntegerDemo {

    static class Counter {
        private AtomicInteger c = new AtomicInteger(0);

        public void increment() {
            c.getAndIncrement();
        }

        public int value() {
            return c.get();
        }
    }

    public static void main(final String[] arguments) throws InterruptedException {
        final Counter counter = new Counter();

        //1000 threads
        for (int i = 0; i < 1000; i++) {

            new Thread(new Runnable() {

                public void run() {
                    System.out.println(Thread.currentThread().getName() + " increment counter -> " + counter.value());
                    counter.increment();
                }
            }).start();
        }
        Thread.sleep(6000);
        System.out.println("Final number (should be 1000): " + counter.value());
    }
}
