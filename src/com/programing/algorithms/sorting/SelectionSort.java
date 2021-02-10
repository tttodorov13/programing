package com.programing.algorithms.sorting;

import java.util.Collections;
import java.util.List;

import static com.programing.algorithms.Utils.*;

/**
 * Swap happens only when once in
 * a Single pass
 * <p>
 * Time Complexity
 * Best: O(n-1)	Worst: O(n^2)	Avg: O(n^2)
 * <p>
 * Space Complexity: O(n)
 * Stable: Yes
 */
public class SelectionSort {

    // Driver method
    public static void main(String[] args) {
        List<Double> list = initializeDoubleList(args, true);

        printListToUi("Printing unsorted elements: ", list);

        SelectionSort.sort(list);

        printListToUi("Printing sorted elements: ", list);
    }

    // Function to sort list of doubles using Selection Sort
    public static void sort(List<Double> list) {
        // One by one move boundary of unsorted subarray
        for (int sortedIndex = 0; sortedIndex < list.size() - 1; sortedIndex++) {
            // Find the minimum element in unsorted array
            int minIndex = sortedIndex;
            for (int j = sortedIndex + 1; j < list.size(); j++)
                if (list.get(j) < list.get(minIndex))
                    minIndex = j;

            // Swap the found minimum element with the first element
            Collections.swap(list, minIndex, sortedIndex);
        }
    }
}
