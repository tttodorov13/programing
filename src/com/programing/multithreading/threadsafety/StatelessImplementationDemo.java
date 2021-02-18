package com.programing.multithreading.threadsafety;

import java.math.BigInteger;

/**
 * Thanks to: https://www.baeldung.com/java-thread-safety
 * <p>
 * The factorial() method is a stateless deterministic function.
 * Given a specific input, it always produces the same output.
 * <p>
 * The method neither relies on external state nor maintains
 * state at all. Hence, it's considered to be thread-safe and
 * can be safely called by multiple threads at the same time.
 * <p>
 * All threads can safely call the factorial() method and
 * will get the expected result without interfering with
 * each other and without altering the output that the method
 * generates for other threads.
 */
public class StatelessImplementationDemo {

    public static void main(String[] args) {
        System.out.printf("Factorial of %d is %d.%n", 5, factorial(5));
    }

    public static BigInteger factorial(int number) {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= number; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }
}
