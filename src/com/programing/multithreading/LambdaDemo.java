package com.programing.multithreading;

public class LambdaDemo {

    String name;

    LambdaDemo(String name) {
        this.name = name;

        // Create new thread using lambda
        new Thread(() -> System.out.println("Do something in another thread.")).start();
    }
}
