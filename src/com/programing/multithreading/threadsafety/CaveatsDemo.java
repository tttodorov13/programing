package com.programing.multithreading.threadsafety;

/**
 * Thanks to: https://www.baeldung.com/java-thread-safety
 * <p>
 * Even though we can use any Java object as an intrinsic
 * lock, we should avoid using Strings for locking purposes.
 * <p>
 * At first glance, it seems that these two classes are using
 * two different objects as their lock. However, because of
 * string interning, these two “Lock” values may actually
 * refer to the same object on the string pool.
 * That is, the Class1 and Class2 are sharing the same lock!
 * <p>
 * This, in turn, may cause some unexpected behaviors
 * in concurrent contexts.
 * <p>
 * In addition to Strings, we should avoid using any cacheable
 * or reusable objects as intrinsic locks.
 * For example, the Integer.valueOf() method caches small numbers.
 * Therefore, calling Integer.valueOf(1) returns the same object
 * even in different classes.
 */
public class CaveatsDemo {

    private int counter = 0;

    public static void main(String[] args) {
        CaveatsDemo caveatsDemo =
                new CaveatsDemo();

        for (int i = 0; i < 5; i++) {
            caveatsDemo.incrementCounter();
        }
    }

    public void incrementCounter() {
        synchronized (Class1.LOCK) {
            counter += 1;
        }

        synchronized (Class2.LOCK) {
            System.out.println(getCounter());
        }
    }

    public int getCounter() {
        return counter;
    }

    class Class1 {
        private static final String LOCK = "Lock";

        // uses the LOCK as the intrinsic lock
    }

    class Class2 {
        private static final String LOCK = "Lock";

        // uses the LOCK as the intrinsic lock
    }
}