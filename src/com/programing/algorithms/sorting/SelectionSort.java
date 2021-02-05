package com.programing.algorithms.sorting;

import java.util.List;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printIntegerListToUi;

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
        List<Integer> list = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", list);

        SelectionSort.sort(list);

        printIntegerListToUi("Printing sorted elements: ", list);
    }

    // Function to sort list of integers using Selection Sort
    public static void sort(List<Integer> list) {
        // One by one move boundary of unsorted subarray
        for (int sortedCount = 0; sortedCount < list.size() - 1; sortedCount++) {
            // Find the minimum element in unsorted array
            int minIndex = sortedCount;
            for (int j = sortedCount + 1; j < list.size(); j++)
                if (list.get(j) < list.get(minIndex))
                    minIndex = j;

            // Swap the found minimum element with the first
            // element
            int temp = list.get(minIndex);
            list.set(minIndex, list.get(sortedCount));
            list.set(sortedCount, temp);
        }
    }
}
