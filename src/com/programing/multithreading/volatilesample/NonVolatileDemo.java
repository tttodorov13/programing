package com.programing.multithreading.volatilesample;

/**
 * Thanks to: https://www.baeldung.com/java-volatile
 *
 * Many may expect this program to simply print 42
 * after a short delay. However, in reality,
 * the delay may be much longer.
 * It may even hang forever, or even print zero!
 *
 * The cause of these anomalies is the lack of
 * proper memory visibility and reordering.
 *
 * In this simple example, we have two application
 * threads: the main thread and the reader thread.
 * Let's imagine a scenario in which the OS schedules
 * those threads on two different CPU cores, where:
 *
 * The main thread has its copy of ready and number
 * variables in its core cache
 * The reader thread ends up with its copies, too
 * The main thread updates the cached values
 * On most modern processors, write requests won't be
 * applied right away after they're issued. In fact,
 * processors tend to queue those writes in a special
 * write buffer. After a while, they will apply those
 * writes to main memory all at once.
 *
 * With all that being said, when the main thread
 * updates the number and ready variables, there is
 * no guarantee about what the reader thread may see.
 * In other words, the reader thread may see the
 * updated value right away, or with some delay,
 * or never at all!
 *
 * This memory visibility may cause liveness issues in
 * programs that are relying on visibility.
 */
public class NonVolatileDemo {

    private static int number;
    private static boolean ready;

    private static class Reader extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }

            System.out.println(number);
        }
    }

    /**
     * To make matters even worse, the reader thread
     * may see those writes in any order other than
     * the actual program order. For instance,
     * since we first update the number variable:
     *
     * We may expect the reader thread prints 42.
     * However, it's actually possible to see zero
     * as the printed value!
     *
     * The reordering is an optimization technique
     * for performance improvements. Interestingly,
     * different components may apply this optimization:
     *
     * The processor may flush its write buffer in any
     * order other than the program order
     * The processor may apply out-of-order execution technique
     * The JIT compiler may optimize via reordering
     */
    public static void main(String[] args) {
        new Reader().start();
        number = 42;
        ready = true;
    }
}
