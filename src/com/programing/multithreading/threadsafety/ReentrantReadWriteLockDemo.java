package com.programing.multithreading.threadsafety;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {

    private int counter;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public ReentrantReadWriteLockDemo(int counter) {
        this.counter = counter;
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo reentrantReadWriteLockDemo =
                new ReentrantReadWriteLockDemo(0);

        for (int i = 0; i < 5; i++) {
            reentrantReadWriteLockDemo.incrementCounter();
            System.out.println(reentrantReadWriteLockDemo.getCounter());
        }
    }

    public void incrementCounter() {
        writeLock.lock();
        try {
            counter += 1;
        } finally {
            writeLock.unlock();
        }
    }

    public int getCounter() {
        readLock.lock();
        try {
            return counter;
        } finally {
            readLock.unlock();
        }
    }
}
