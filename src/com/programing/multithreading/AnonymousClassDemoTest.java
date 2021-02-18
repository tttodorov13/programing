package com.programing.multithreading;

public class AnonymousClassDemoTest {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            AnonymousClassDemo anonymousClassDemo = new AnonymousClassDemo("Thread-" + i);
            System.out.println(anonymousClassDemo.name);
        }
    }
}
