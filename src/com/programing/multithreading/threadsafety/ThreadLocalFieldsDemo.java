package com.programing.multithreading.threadsafety;

/**
 * https://www.baeldung.com/java-thread-safety
 * <p>
 * Thread-local fields are pretty much like normal class fields,
 * except that each thread that accesses them via a setter/getter
 * gets an independently initialized copy of the field so that
 * each thread has its own state.
 */
public class ThreadLocalFieldsDemo {

    public static void main(String[] args) {
        System.out.println(getState());
    }

    public static final ThreadLocal<StateHolder> statePerThread =
            new ThreadLocal<StateHolder>() {

                @Override
                protected StateHolder initialValue() {
                    return new StateHolder("active");
                }
            };

    public static StateHolder getState() {
        return statePerThread.get();
    }
}

class StateHolder {

    private final String state;

    StateHolder(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
