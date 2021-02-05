package com.programing.algorithms.sorting;

import java.util.List;

import static com.programing.algorithms.Utils.*;
import static com.programing.algorithms.Utils.printIntegerListToUi;

/**
 * Time Complexity
 * Best: O(n*k/s)   Worst: O(2^s*n*k/s) Avg: O(n*k/s)
 * <p>
 * Space Complexity: O(n)
 * Stable: No
 */
public class RadixSort {

    // Driver method
    public static void main(String[] args) {
        List<Integer> list = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", list);

        RadixSort ob = new RadixSort();
        ob.sort(list);

        printIntegerListToUi("Printing sorted elements: ", list);
    }

    // Function to sort list of integers using Radix Sort
    public void sort(List<Integer> list) {
        // Find the maximum number to know number of digits
        int m = list.stream().max(Integer::compare).get();

        CountingSort countingSort = new CountingSort();
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countingSort.sort(list);
    }
}