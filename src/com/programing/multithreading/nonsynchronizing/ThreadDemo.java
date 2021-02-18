package com.programing.multithreading.nonsynchronizing;

/**
 * Thanks to https://www.tutorialspoint.com/java/java_thread_synchronization.htm
 */
class ThreadDemo extends Thread {
    private Thread thread;
    PrintDemo printDemo;

    ThreadDemo(String name, PrintDemo pd) {
        setName(name);
        printDemo = pd;
    }

    public void run() {
        printDemo.printCount();
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