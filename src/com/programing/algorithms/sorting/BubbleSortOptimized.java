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
        int indexInnerLoop, indexOuterLoop, temp;
        boolean isOrdered = true;
        // Traverse all elements
        for (indexInnerLoop = 0; indexInnerLoop < list.size(); indexInnerLoop++) {
            // Create flag for sorted list
            // Traverse all elements without the last one
            for (indexOuterLoop = 0; indexOuterLoop < list.size() - 1 - indexInnerLoop; indexOuterLoop++) {
                // Compare the current element with the next one
                // If they are not in the right consequence, swap them
                if (list.get(indexOuterLoop) > list.get(indexOuterLoop + 1)) {
                    temp = list.get(indexOuterLoop);
                    list.set(indexOuterLoop, list.get(indexOuterLoop + 1));
                    list.set(indexOuterLoop + 1, temp);
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
