package com.programing.multithreading.threadsafety;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thanks to: https://www.baeldung.com/java-thread-safety
 * <p>
 * This is thread-safe because, while incrementation, ++,
 * takes more than one operation, incrementAndGet is atomic.
 */
public class AtomicObjectDemo {

    private final AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) {
        AtomicObjectDemo atomicObjectDemo = new AtomicObjectDemo();

        for (int i = 0; i < 5; i++) {
            atomicObjectDemo.incrementCounter();
            System.out.println(atomicObjectDemo.getCounter());
        }
    }

    public void incrementCounter() {
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }
}
