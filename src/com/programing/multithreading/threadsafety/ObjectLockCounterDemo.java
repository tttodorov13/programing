package com.programing.multithreading.threadsafety;

/**
 * Thanks to: https://www.baeldung.com/java-thread-safety
 * <p>
 * We can slightly improve the thread-safe implementation
 * of the Counter class by exploiting another object as a
 * monitor lock, instead of this.
 * <p>
 * Not only does this provide coordinated access to a shared
 * resource in a multithreaded environment, but also it uses
 * an external entity to enforce exclusive access to the resource.
 * <p>
 * We use a plain Object instance to enforce mutual exclusion.
 * This implementation is slightly better, as it promotes security
 * at the lock level.
 * <p>
 * When using this for intrinsic locking, an attacker could cause
 * a deadlock by acquiring the intrinsic lock and triggering
 * a denial of service (DoS) condition.
 * <p>
 * On the contrary, when using other objects, that private entity
 * is not accessible from the outside. This makes it harder for
 * an attacker to acquire the lock and cause a deadlock.
 */
public class ObjectLockCounterDemo {

    private int counter = 0;
    private final Object lock = new Object();

    public static void main(String[] args) {
        ObjectLockCounterDemo objectLockCounterDemo =
                new ObjectLockCounterDemo();

        for (int i = 0; i < 5; i++) {
            objectLockCounterDemo.incrementCounter();
            System.out.println(objectLockCounterDemo.getCounter());
        }
    }

    public void incrementCounter() {
        synchronized (lock) {
            counter += 1;
        }
    }

    public int getCounter() {
        return counter;
    }
}
