package com.programing.multithreading.waitnotify;

/**
 * Thanks to: https://www.baeldung.com/java-wait-notify
 */
public class Data {

    private String packet;

    // True if receiver should wait
    // False if sender should wait
    private boolean transfer = true;

    public synchronized void send(String packet) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                System.out.println("Error: Data.send() Thread interrupted");
            }
        }
        transfer = false;

        this.packet = packet;
        notify();
    }

    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                System.out.println("Error: Data.receive() Thread interrupted");
            }
        }
        transfer = true;

        notify();
        return packet;
    }
}
