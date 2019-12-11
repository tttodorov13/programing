package com.programing.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printIntegerListToUi;

/**
 * Time Complexity
 * Best: O(n*k) Worst: O(n^^2*k)    Avg: O(n*k)
 * <p>
 * Space Complexity: O(n*k)
 * Stable: Yes
 */
public class BucketSort {

    // Driver method
    public static void main(String[] args) {
        List<Integer> a = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", a);

        BucketSort ob = new BucketSort();
        ob.sort(a);

        printIntegerListToUi("Printing sorted elements: ", a);
    }

    // Function to sort list of integers using Bucket Sort
    public void sort(List<Integer> a) {
        int max_value = a.stream().max(Integer::compare).get();
        int[] Bucket = new int[max_value + 1];
        int[] sortedA = new int[a.size()];
        for (int i = 0; i < a.size(); i++)
            Bucket[a.get(i)]++;
        int outPos = 0;
        for (int i = 0; i < Bucket.length; i++) {
            for (int j = 0; j < Bucket[i]; j++)
                sortedA[outPos++] = i;
        }
        for (int i = 0; i < sortedA.length; i++)
            a.set(i, sortedA[i]);
    }
}