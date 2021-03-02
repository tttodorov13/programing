package com.programing.multithreading.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Thanks to: https://www.tutorialspoint.com/java_concurrency/concurrency_atomicreference.htm
 */
public class AtomicReferenceDemo {

    private static String message = "hello";
    private static AtomicReference<String> atomicReference;

    public static void main(final String[] arguments) throws InterruptedException {
        atomicReference = new AtomicReference<String>(message);

        new Thread("Thread 1") {

            public void run() {
                atomicReference.compareAndSet(message, "Thread 1");
                message = message.concat("-Thread 1!");
            };
        }.start();

        System.out.println("Message is: " + message);
        System.out.println("Atomic Reference of Message is: " + atomicReference.get());
    }
}
