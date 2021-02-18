package com.programing.multithreading.synchronizing;

/**
 * Thanks to https://www.tutorialspoint.com/java/java_thread_synchronization.htm
 */
public class TestSynchronizedThreadDemo {

    public static void main(String args[]) {
        PrintDemo printDemo = new PrintDemo();

        SynchronizedThreadDemo thread1 = new SynchronizedThreadDemo( "Thread-1 ", printDemo );
        SynchronizedThreadDemo thread2 = new SynchronizedThreadDemo( "Thread-2 ", printDemo );

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
