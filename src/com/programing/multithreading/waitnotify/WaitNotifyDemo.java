package com.programing.multithreading.waitnotify;

/**
 * Thanks to: https://www.baeldung.com/java-wait-notify
 */
public class WaitNotifyDemo {

    public static void main(String[] args) {
        Data data = new Data();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));
        sender.start();
        receiver.start();
    }
}
