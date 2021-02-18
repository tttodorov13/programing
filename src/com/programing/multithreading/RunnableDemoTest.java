package com.programing.multithreading;

public class RunnableDemoTest {

    public static void main(String args[]) {
        for (int i = 1; i <= 10; i++) {
            RunnableDemo runnableDemo = new RunnableDemo("Thread-" + i);
            runnableDemo.start();
        }
    }
}