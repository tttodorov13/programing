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
        List<Integer> a = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", a);

        InsertionSort ob = new InsertionSort();
        ob.sort(a);

        printIntegerListToUi("Printing sorted elements: ", a);
    }

    // Function to sort list of integers using insertion sort
    void sort(List<Integer> a) {
        for (int i = 1; i < a.size(); ++i) {
            int key = a.get(i);
            int j = i - 1;

            /* Move elements of a{0..i-1}, that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && a.get(j) > key) {
                a.set(j + 1, a.get(j));
                j = j - 1;
            }
            a.set(j + 1, key);
        }
    }
}
