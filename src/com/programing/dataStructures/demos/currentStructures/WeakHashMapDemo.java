/**
 * Thanks to https://www.tutorialspoint.com/java/java_weakhashmap_class.htm
 */
package com.programing.dataStructures.demos.currentStructures;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

    private static Map map;

    public static void main(String args[]) {

        map = new WeakHashMap();
        /**
         * If implemented map.put("Maine", "Augusta") the GC may be not called
         * as not too much memory is used.
         */

        map.put( new String("Maine"), "Augusta");

        Runnable runner = () -> {
            while (map.containsKey("Maine")) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {
                }
                System.out.println("Thread waiting");
                System.gc();
            }
        };

        Thread t = new Thread(runner);
        t.start();
        System.out.println("Main waiting");

        try {
            t.join();
        } catch (InterruptedException ignored) {
            System.err.printf("InterruptedException: %s", ignored);
        }
    }
}
