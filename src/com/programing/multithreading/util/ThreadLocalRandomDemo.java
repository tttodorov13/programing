package com.programing.multithreading.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Thanks to: https://www.tutorialspoint.com/java_concurrency/concurrency_threadlocalrandom.htm
 */
public class ThreadLocalRandomDemo {

    private static final int LEAST = 5;
    private static final int BOUND = 10;

    public static void main(final String[] arguments) {
        System.out.println("Random Integer: " + new Random().nextInt());
        System.out.println("Seeded Random Integer: " + new Random(15).nextInt());
        System.out.println(
                "Thread Local Random Integer: " + ThreadLocalRandom.current().nextInt());

        final ThreadLocalRandom random = ThreadLocalRandom.current();

        System.out.printf("Thread Local Random Integer between 0 and %d: %d%n", BOUND, random.nextInt(BOUND));
        System.out.printf("Thread Local Random Integer between %d and %d: %d%n", LEAST, BOUND, random.nextInt(LEAST, BOUND));

        System.out.printf("Thread Local Random Long: %d%n", random.nextLong());
        System.out.printf("Thread Local Random Long between 0 and %d: %d%n", BOUND, random.nextLong(BOUND));
        System.out.printf("Thread Local Random Long between %d and %d: %d%n", LEAST, BOUND, random.nextLong(LEAST, BOUND));

        System.out.printf("Thread Local Random Float: %f%n", random.nextFloat());

        System.out.printf("Thread Local Random Double: %f%n", random.nextDouble());
        System.out.printf("Thread Local Random Double between 0 and %f: %f%n", (double) BOUND, random.nextDouble(BOUND));
        System.out.printf("Thread Local Random Double between %f and %f: %f%n", (double) LEAST, (double) BOUND, random.nextDouble(LEAST, BOUND));

        //exception will come as seeding is not allowed in ThreadLocalRandom.
        random.setSeed(BOUND);
        System.out.println("Seeded Thread Local Random Integer: " + random.nextInt());
    }
}
