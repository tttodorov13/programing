package com.programing.multithreading;

public class ThreadDemoTest {

    public static void main(String args[]) {
        for (int i = 1; i <= 10; i++) {
            ThreadDemo threadDemo = new ThreadDemo("Thread-" + i);
            threadDemo.setPriority(i);
            System.out.println("thread: " + threadDemo.getName() + ", priority: " + threadDemo.getPriority());
            threadDemo.start();
            System.out.println("threadDemo.currentThread() " + threadDemo.currentThread());
        }
    }
}
