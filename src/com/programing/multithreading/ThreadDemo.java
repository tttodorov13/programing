package com.programing.multithreading;

public class ThreadDemo extends Thread {

    private Thread thread;

    ThreadDemo(String name) {
        setName(name);
        System.out.println("Creating " + getName());
    }

    public void run() {
        System.out.println("Running " + getName());
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + getName() + " sleeps 50 ms");
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + getName() + " interrupted.");
        }
        System.out.println("Thread: " + getName() + " exiting.");
        System.out.println("Thread: " + getName() + " holdsLock(this): " + holdsLock(this));
        System.out.println("Thread: " + getName() + " currentThread: " + currentThread());
        System.out.println("Thread: " + getName() + " dumpStack: ");
        System.out.println(currentThread());
    }

    public void start() {
        System.out.println("Starting " + getName());
        if (thread == null) {
            thread = new Thread(this, getName());
            thread.start();
        }
    }
}