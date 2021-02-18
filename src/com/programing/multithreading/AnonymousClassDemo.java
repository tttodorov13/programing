package com.programing.multithreading;

public class AnonymousClassDemo {

    String name;

    AnonymousClassDemo(String name) {
        this.name = name;

        // Create new thread using anonymous class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Do stuff");
            }
        }).start();
    }
}
