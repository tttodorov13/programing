package com.programing.multithreading;

public class ThreadJoin extends Thread {

    public int processingCount = 0;

    ThreadJoin(int processingCount) {
        this.processingCount = processingCount;
        System.out.println("INFO: ThreadJoin.ThreadJoin() Thread Created");
    }

    public static void main(String[] args) {
        ThreadJoin threadJoin = new ThreadJoin(1);
        try {
            threadJoin.givenStartedThread_whenJoinCalled_waitsTillCompletion();
        } catch (InterruptedException e) {
            System.out.println("ERROR: ThreadJoin.main() throws InterruptedException");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("INFO: Thread " + this.getName() + " started");
        while (processingCount > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("INFO: Thread " + this.getName() + " interrupted");
            }
            processingCount--;
        }
        System.out.println("INFO: Thread " + this.getName() + " existing");
    }

    public void givenStartedThread_whenJoinCalled_waitsTillCompletion()
            throws InterruptedException {
        Thread thread = new ThreadJoin(1);
        thread.start();
        System.out.println("INFO: Invoking join");
        thread.join();
        System.out.println("INFO: Returned from join");
        System.out.println("INFO: thread.isAlive(): " + thread.isAlive());
    }
}
