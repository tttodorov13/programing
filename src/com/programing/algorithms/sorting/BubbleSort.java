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
 * Best: O(N^2)	Worst: O(N^2)	Avg: O(N^2)
 * <p>
 * Space Complexity: O(N)
 * Stable: Yes
 */
public class BubbleSort {

    // Driver method
    public static void main(String[] args) {
        List<Double> list = initializeDoubleList(args, true);

        printListToUi("Printing unsorted elements: ", list);

        BubbleSort.sort(list);

        printListToUi("Printing sorted elements: ", list);
    }

    // Function to sort list of doubles using bubble sort
    public static void sort(List<Double> list) {
        int indexOuterLoop, indexInnerLoop;

        // Traverse all elements
        for (indexOuterLoop = 0; indexOuterLoop < list.size(); indexOuterLoop++)
            // Traverse all elements without the last one
            for (indexInnerLoop = 0; indexInnerLoop < list.size(); indexInnerLoop++)
                // Compare the current element with the next one
                // If they are not in the right consequence, swap them
                if (list.get(indexOuterLoop) < list.get(indexInnerLoop))
                    Collections.swap(list, indexOuterLoop, indexInnerLoop);
    }
}
