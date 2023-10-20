package com.programing.designPatterns.creational.Singleton;

public class SingletonClass {

    private static SingletonClass INSTANCE = null;

    // Make the constructor private so that this class
    // cannot be instantiated
    private SingletonClass() {
    }

    // Get the only object available with
    // lazy Initialization
    public static SingletonClass getInstance() {
        synchronized (SingletonClass.class) {
            if (INSTANCE == null)
                INSTANCE = new SingletonClass();
        }
        return INSTANCE;
    }

    public void showMessage() {
        System.out.println("SingletonClass");
    }
}
