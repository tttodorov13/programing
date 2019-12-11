package com.programing.algorithms.sorting;

import java.util.List;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printIntegerListToUi;

/**
 * Swap happens only when once in
 * a Single pass
 * <p>
 * Time Complexity
 * Best: O(n^2)	Worst: O(n^2)	Avg: O(n^2)
 * <p>
 * Space Complexity: O(1)
 * Stable: Yes
 */
public class SelectionSort {

    // Driver method
    public static void main(String[] args) {
        List<Integer> a = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", a);

        SelectionSort.sort(a);

        printIntegerListToUi("Printing sorted elements: ", a);
    }

    // Function to sort list of integers using Selection Sort
    public static void sort(List<Integer> a) {
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < a.size() - 1; i++) {
            // Find the minimum element in unsorted array
            int min_index = i;
            for (int j = i + 1; j < a.size(); j++)
                if (a.get(j) < a.get(min_index))
                    min_index = j;

            // Swap the found minimum element with the first
            // element
            int temp = a.get(min_index);
            a.set(min_index, a.get(i));
            a.set(i, temp);
        }
    }
}
