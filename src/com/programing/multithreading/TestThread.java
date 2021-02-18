package com.programing.multithreading;

public class TestThread {

    public static void main(String args[]) {
        ThreadDemo R1 = new ThreadDemo("Thread-1");
        R1.start();

        ThreadDemo R2 = new ThreadDemo("Thread-2");
        R2.start();

        try {
            Thread.sleep(1000);
            R1.interrupt();
            System.out.println("Suspending First Thread");
            Thread.sleep(1000);
            R1.start();
            System.out.println("Resuming First Thread");

            R2.interrupt();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            R2.start();
            System.out.println("Resuming thread Two");
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        try {
            System.out.println("Waiting for threads to finish.");
            R1.join();
            R2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        System.out.println("Main thread exiting.");
    }
}
