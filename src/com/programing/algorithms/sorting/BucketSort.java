package com.programing.algorithms.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.programing.algorithms.Utils.initializeDoubleList;
import static com.programing.algorithms.Utils.printListToUi;

/**
 * K - number of buckets to spread numbers to,
 * in this implementation square root of N
 * Time Complexity
 * Best: O(N*K) Worst: O(N^2)    Avg: O(N^2)
 * <p>
 * Space Complexity: O(n*k)
 * Stable: Yes
 */
public class BucketSort {

    // Driver method
    public static void main(String[] args) {
        List<Double> list = initializeDoubleList(args);

        printListToUi("Printing unsorted elements: ", list);

        BucketSort.sort(list);

        printListToUi("Printing sorted elements: ", list);
    }

    // Function to sort list of doubles using Bucket Sort
    public static void sort(List<Double> list) {
        // Create a list of buckets with number of elements
        // square root of the elements to order
        List<List<Double>> buckets = new ArrayList<>();
        final int numberOfBuckets = (int) Math.sqrt(list.size());
        for (int i = 0; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());

        // distribute each element of our input list
        // into its relevant bucket using the hash method:
        double max = list.stream().max(Double::compare).get();
        for (double i : list)
            buckets.get(hash(i, max, numberOfBuckets)).add(i);

        // Use a Comparator to sort any bucket
        Comparator<Double> comparator = Comparator.naturalOrder();
        for (List<Double> bucket : buckets)
            bucket.sort(comparator);

        // Concatenate the buckets
        list.clear();
        for (List<Double> bucket : buckets)
            list.addAll(bucket);
    }

    private static int hash(double i, double max, int numberOfBuckets) {
        return (int) (i / max * (numberOfBuckets - 1));
    }
}