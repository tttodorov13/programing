package com.programing.multithreading.threadsafety;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Thanks to: https://www.baeldung.com/java-thread-safety
 * <p>
 * Java provides the java.util.concurrent package, which contains
 * several concurrent collections, such as ConcurrentHashMap:
 * <p>
 * Unlike their synchronized counterparts, concurrent collections
 * achieve thread-safety by dividing their data into segments.
 * In a ConcurrentHashMap, for instance, several threads can
 * acquire locks on different map segments, so multiple threads
 * can access the Map at the same time.
 * <p>
 * Concurrent collections are much more performant than
 * synchronized collections, due to the inherent advantages
 * of concurrent thread access.
 * <p>
 * It's worth mentioning that synchronized and concurrent
 * collections only make the collection itself thread-safe
 * and not the contents.
 */
public class ConcurrentCollectionDemo {

    public static void main(String[] args) {
        Map<String, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("1", "one");
        concurrentMap.put("2", "two");
        concurrentMap.put("3", "three");

        for (Map.Entry<String, String> e :
                concurrentMap.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
