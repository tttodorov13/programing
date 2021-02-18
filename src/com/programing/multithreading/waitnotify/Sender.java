package com.programing.multithreading.waitnotify;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Thanks to: https://www.baeldung.com/java-wait-notify
 */
public class Sender implements Runnable {

    private Data data;

    public Sender(Data data) {
        this.data = data;
    }

    public void run() {
        String packets[] = {
                "First packet",
                "Second packet",
                "Third packet",
                "Fourth packet",
                "End"
        };

        for (String packet : packets) {
            data.send(packet);

            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt();
                System.out.println("Error: Sender.send() Thread interrupted");
            }
        }
    }
}
