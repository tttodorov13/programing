package com.programing.multithreading.threadsafety;

/**
 * Thanks to: https://www.baeldung.com/java-thread-safety
 * <p>
 * The object is effectively immutable since its state can't
 * change after its construction. Hence, it's thread-safe.
 * <p>
 * Moreover, if MessageService were actually mutable,
 * but multiple threads only have read-only access to it,
 * it's thread-safe as well.
 * <p>
 * Thus, immutability is just another way to achieve thread-safety.
 */
public class ImmutableImplementationDemo {

    private final String message;

    public ImmutableImplementationDemo(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        ImmutableImplementationDemo immutableImplementationDemo =
                new ImmutableImplementationDemo("message");
        System.out.println(immutableImplementationDemo.getMessage());
    }

    public String getMessage() {
        return message;
    }
}
