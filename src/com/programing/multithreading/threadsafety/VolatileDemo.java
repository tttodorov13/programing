package com.programing.multithreading.threadsafety;

/**
 * Thanks to: https://www.baeldung.com/java-thread-safety
 * <p>
 * Synchronized methods and blocks are handy for addressing
 * variable visibility problems among threads. Even so,
 * the values of regular class fields might be cached by the CPU.
 * Hence, consequent updates to a particular field, even if
 * they're synchronized, might not be visible to other threads.
 * <p>
 * To prevent this situation, we can use volatile class fields
 * <p>
 * With the volatile keyword, we instruct the JVM and the compiler
 * to store the counter variable in the main memory. That way,
 * we make sure that every time the JVM reads the value of
 * the counter variable, it will actually read it from
 * the main memory, instead of from the CPU cache. Likewise,
 * every time the JVM writes to the counter variable,
 * the value will be written to the main memory.
 * <p>
 * Moreover, the use of a volatile variable ensures that
 * all variables that are visible to a given thread
 * will be read from the main memory as well.
 * <p>
 * This extended guarantee that volatile variables provide
 * is known as the full volatile visibility guarantee.
 */
public class VolatileDemo {

    private String name;
    private volatile int age;

    public VolatileDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        VolatileDemo volatileDemo =
                new VolatileDemo("name", 0);

        for (int i = 0; i < 5; i++) {
            volatileDemo.incrementCounter();
            System.out.println(volatileDemo.getName() + " "
                    + volatileDemo.getAge());
        }
    }

    public void incrementCounter() {
        age++;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
