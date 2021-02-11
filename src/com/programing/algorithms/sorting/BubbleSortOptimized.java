package com.programing.algorithms.sorting;

import java.util.Collections;
import java.util.List;

import static com.programing.algorithms.Utils.initializeDoubleList;
import static com.programing.algorithms.Utils.printListToUi;

/**
 * For each pair of indices, swap the
 * elements if they are out of order
 * <p>
 * Time Complexity
 * Best: O(N)	Worst: O(N^2)	Avg: O(N^2)
 * <p>
 * Space Complexity: O(N)
 * Stable: Yes
 */
public class BubbleSortOptimized {

    // Driver method
    public static void main(String[] args) {
        List<Double> list = initializeDoubleList(args, true);

        printListToUi("Printing unsorted elements: ", list);

        long begin = System.nanoTime();
        BubbleSortOptimized.sort(list);
        System.out.printf("Time elapsed: %f s", (System.nanoTime() - begin) / 1000000000.0);

        printListToUi("\nPrinting sorted elements: ", list);
    }

    // Function to sort list of doubles using bubble sort
    public static void sort(List<Double> list) {
        int indexOuterLoop, indexInnerLoop;
        boolean isOrdered = true;

        // Traverse all elements
        for (indexOuterLoop = 0; indexOuterLoop < list.size(); indexOuterLoop++) {
            // Create flag for sorted list
            // Traverse all elements without the last one
            for (indexInnerLoop = 0; indexInnerLoop < list.size() - 1 - indexOuterLoop; indexInnerLoop++) {
                // Compare the current element with the next one
                // If they are not in the right consequence, swap them
                if (list.get(indexInnerLoop) > list.get(indexInnerLoop + 1)) {
                    Collections.swap(list, indexInnerLoop, indexInnerLoop + 1);
                    // Mark true if there is a swap
                    isOrdered = false;
                }
            }
            // If list is ordered stop
            if (isOrdered)
                break;
        }
    }
}
