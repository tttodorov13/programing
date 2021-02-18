package com.programing.multithreading.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Thanks to: https://www.tutorialspoint.com/java_concurrency/concurrency_lock.htm
 */
public class LockDemo {
    public static void main(String args[]) {
        PrintDemo PD = new PrintDemo();

        ThreadLockDemo t1 = new ThreadLockDemo("Thread - 1 ", PD);
        ThreadLockDemo t2 = new ThreadLockDemo("Thread - 2 ", PD);
        ThreadLockDemo t3 = new ThreadLockDemo("Thread - 3 ", PD);
        ThreadLockDemo t4 = new ThreadLockDemo("Thread - 4 ", PD);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class ThreadLockDemo extends Thread {
    PrintDemo printDemo;

    ThreadLockDemo(String name, PrintDemo printDemo) {
        super(name);
        this.printDemo = printDemo;
    }

    @Override
    public void run() {
        System.out.printf(
                "%s starts printing a document\n", Thread.currentThread().getName());
        printDemo.print();
    }
}

class PrintDemo {

    private final Lock queueLock = new ReentrantLock();

    public void print() {
        queueLock.lock();

        try {
            Long duration = (long) (Math.random() * 5000);
            System.out.println(Thread.currentThread().getName()
                    + "  Time Taken " + (duration / 1000) + " seconds.");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf(
                    "%s printed the document successfully.\n", Thread.currentThread().getName());
            queueLock.unlock();
        }
    }
}
