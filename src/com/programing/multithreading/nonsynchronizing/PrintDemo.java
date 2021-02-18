package com.programing.multithreading.nonsynchronizing;

/**
 * Thanks to https://www.tutorialspoint.com/java/java_thread_synchronization.htm
 */
class PrintDemo {

    public void printCount() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Counter   ---   " + i);
            }
        } catch (Exception e) {
            System.out.println("Thread interrupted.");
        }
    }
}
