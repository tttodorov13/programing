package com.programing.algorithms.sorting;

import java.util.List;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printIntegerListToUi;

/**
 * For each pair of indices, swap the
 * elements if they are out of order
 * <p>
 * Time Complexity
 * Best: O(n)	Worst: O(n^2)	Avg: O(n^2)
 * <p>
 * Space Complexity: O(n)
 * Stable: Yes
 */
public class BubbleSortOptimized {

    // Driver method
    public static void main(String[] args) {
        List<Integer> list = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", list);

        BubbleSortOptimized.sort(list);

        printIntegerListToUi("Printing sorted elements: ", list);
    }

    // Function to sort list of integers using bubble sort
    public static List<Integer> sort(List<Integer> list) {
        // Traverse all elements
        for (int i = 0; i < list.size(); i++) {
            // Create flag for sorted list
            boolean isOrdered = true;
            // Traverse all elements without the last one
            for (int j = 0; j < list.size() - 1 - i; j++) {
                // Compare the current element with the next one
                // If they are not in the right consequence, swap them
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    // Mark true if there is a swap
                    isOrdered = false;
                }
            }
            // If list is ordered stop
            if (isOrdered)
                break;
        }
        return list;
    }
}
