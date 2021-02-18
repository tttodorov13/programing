package com.programing.multithreading.threadsafety;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Thanks to: https://www.baeldung.com/java-thread-safety
 * <p>
 * Java provides an improved set of Lock implementations,
 * whose behavior is slightly more sophisticated than
 * the intrinsic locks discussed above.
 * <p>
 * With intrinsic locks, the lock acquisition model is
 * rather rigid: one thread acquires the lock,
 * then executes a method or code block,
 * and finally releases the lock, so other threads
 * can acquire it and access the method.
 * <p>
 * There's no underlying mechanism that checks
 * the queued threads and gives priority access to
 * the longest waiting threads.
 * <p>
 * ReentrantLock instances allow us to do exactly that,
 * hence preventing queued threads from suffering some
 * types of resource starvation.
 * <p>
 * The ReentrantLock constructor takes an optional
 * fairness boolean parameter. When set to true,
 * and multiple threads are trying to acquire a lock,
 * the JVM will give priority to the longest waiting
 * thread and grant access to the lock.
 */
public class ReentrantLockDemo {

    private int counter;
    private final ReentrantLock reLock = new ReentrantLock(true);

    public ReentrantLockDemo(int counter) {
        this.counter = counter;
    }

    public static void main(String[] args) {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo(0);

        for (int i = 0; i < 5; i++) {
            reentrantLockDemo.incrementCounter();
            System.out.println(reentrantLockDemo.getCounter());
        }
    }

    public void incrementCounter() {
        reLock.lock();
        try {
            counter += 1;
        } finally {
            reLock.unlock();
        }
    }

    public int getCounter() {
        return counter;
    }
}
