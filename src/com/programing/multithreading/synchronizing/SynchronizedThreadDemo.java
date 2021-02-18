package com.programing.multithreading.synchronizing;

/**
 * Thanks to https://www.tutorialspoint.com/java/java_thread_synchronization.htm
 */
class SynchronizedThreadDemo extends Thread {
    private Thread thread;
    PrintDemo printDemo;

    SynchronizedThreadDemo(String name, PrintDemo pd) {
        setName(name);
        printDemo = pd;
    }

    public void run() {
        synchronized (printDemo) {
            printDemo.printCount();
        }
        System.out.println("Thread " + getName() + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + getName());
        if (thread == null) {
            thread = new Thread(this, getName());
            thread.start();
        }
    }
}