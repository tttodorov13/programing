package com.programing.multithreading.nonsynchronizing;

/**
 * Thanks to https://www.tutorialspoint.com/java/java_thread_synchronization.htm
 */
public class TestThreadDemo {

    public static void main(String args[]) {
        PrintDemo printDemo = new PrintDemo();

        ThreadDemo thread1 = new ThreadDemo( "Thread-1 ", printDemo );
        ThreadDemo thread2 = new ThreadDemo( "Thread-2 ", printDemo );

        thread1.start();
        thread2.start();

        // wait for threads to end
        try {
            thread1.join();
            thread2.join();
        } catch ( Exception e) {
            System.out.println("Interrupted");
        }
    }
}
