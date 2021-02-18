package com.programing.multithreading.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Thanks to: https://www.tutorialspoint.com/java_concurrency/concurrency_readwritelock.htm
 */
public class ReadWriteLockDemo {

    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private static String message = "a";

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new WriterA());
        thread1.setName("Writer A");

        Thread thread2 = new Thread(new WriterB());
        thread2.setName("Writer B");

        Thread thread3 = new Thread(new Reader());
        thread3.setName("Reader");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }

    static class Reader implements Runnable {

        public void run() {

            if (lock.isWriteLocked()) {
                System.out.println("Write Lock Present.");
            }
            lock.readLock().lock();

            try {
                Long duration = (long) (Math.random() * 5000);
                System.out.println(Thread.currentThread().getName()
                        + " Time Taken " + (duration / 1000) + " seconds.");
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + ": " + message);
                lock.readLock().unlock();
            }
        }
    }

    static class WriterA implements Runnable {

        public void run() {
            lock.writeLock().lock();

            try {
                Long duration = (long) (Math.random() * 5000);
                System.out.println(Thread.currentThread().getName()
                        + " Time Taken " + (duration / 1000) + " seconds.");
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                message = message.concat("a");
                lock.writeLock().unlock();
            }
        }
    }

    static class WriterB implements Runnable {

        public void run() {
            lock.writeLock().lock();

            try {
                Long duration = (long) (Math.random() * 5000);
                System.out.println(Thread.currentThread().getName()
                        + " Time Taken " + (duration / 1000) + " seconds.");
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                message = message.concat("b");
                lock.writeLock().unlock();
            }
        }
    }
}
