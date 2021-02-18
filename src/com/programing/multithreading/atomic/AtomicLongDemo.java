package com.programing.multithreading.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Thanks to: https://www.tutorialspoint.com/java_concurrency/concurrency_atomiclong.htm
 */
public class AtomicLongDemo {

    static class Counter {
        private AtomicLong c = new AtomicLong(0);

        public void increment() {
            c.getAndIncrement();
        }

        public long value() {
            return c.get();
        }
    }

    public static void main(final String[] arguments) throws InterruptedException {
        final Counter counter = new Counter();

        //1000 threads
        for(int i = 0; i < 1000 ; i++) {

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
