package com.programing.algorithms.sorting;

import java.util.List;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printIntegerListToUi;

/**
 * Very small constant factor even if
 * the complexity is O(n^2)
 * <b>Best Case:<b/> List already sorted
 * <b>Worst Case:</b> sorted in reverse order
 * <p>
 * Time Complexity
 * Best: O(n)	Worst: O(n^2)	Avg: O(n^2)
 * <p>
 * Space Complexity: O(1)
 * Stable: Yes
 */
public class InsertionSort {

    // Driver method
    public static void main(String[] args) {
        List<Integer> list = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", list);

        InsertionSort.sort(list);

        printIntegerListToUi("Printing sorted elements: ", list);
    }

    // Function to sort list of integers using Insertion Sort
    public static void sort(List<Integer> list) {
        for (int i = 1; i < list.size(); ++i) {
            int key = list.get(i);
            int j = i - 1;

            /* Move elements of list{0..i-1}, that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
    }
}
