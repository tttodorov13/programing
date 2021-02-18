package com.programing.multithreading.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Thanks to: https://www.tutorialspoint.com/java_concurrency/concurrency_executor.htm
 */
public class ExecutorDemo {

    public static void main(final String[] arguments) throws InterruptedException {
        Executor executor = Executors.newCachedThreadPool();
        executor.execute(new Task());
        ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;
        pool.shutdown();
    }

    static class Task implements Runnable {

        public void run() {

            try {
                Long duration = (long) (Math.random() * 5);
                System.out.println("Running Task!");
                TimeUnit.SECONDS.sleep(duration);
                System.out.printf("Task Completed for %d seconds", duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
