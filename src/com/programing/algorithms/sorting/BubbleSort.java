package com.programing.algorithms.sorting;

import java.util.List;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printIntegerListToUi;

/**
 * For each pair of indices, swap the
 * elements if they are out of order
 * <p>
 * Time Complexity
 * Best: O(n^2)	Worst: O(n^2)	Avg: O(n^2)
 * <p>
 * Space Complexity: O(n)
 * Stable: Yes
 */
public class BubbleSort {

    // Driver method
    public static void main(String[] args) {
        List<Integer> list = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", list);

        BubbleSort.sort(list);

        printIntegerListToUi("Printing sorted elements: ", list);
    }

    // Function to sort list of integers using bubble sort
    public static List<Integer> sort(List<Integer> list) {
        int indexInnerLoop, indexOuterLoop, temp;
        // Traverse all elements
        for (indexInnerLoop = 0; indexInnerLoop < list.size(); indexInnerLoop++) {
            // Traverse all elements without the last one
            for (indexOuterLoop = 0; indexOuterLoop < list.size(); indexOuterLoop++) {
                // Compare the current element with the next one
                // If they are not in the right consequence, swap them
                if (list.get(indexInnerLoop) < list.get(indexOuterLoop)) {
                    temp = list.get(indexInnerLoop);
                    list.set(indexInnerLoop, list.get(indexOuterLoop));
                    list.set(indexOuterLoop, temp);
                }
            }
        }
        return list;
    }
}
