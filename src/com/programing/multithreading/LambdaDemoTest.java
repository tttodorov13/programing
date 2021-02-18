package com.programing.multithreading;

public class LambdaDemoTest {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            LambdaDemo lambdaDemo = new LambdaDemo("Thread-" + i);
            System.out.println(lambdaDemo.name);
        }
    }
}
