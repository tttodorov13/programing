package com.programing.algorithms.sorting;

import java.util.Arrays;
import java.util.List;

import static com.programing.algorithms.Utils.*;

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
        List<Double> list = initializeDoubleList(args, true);

        printListToUi("Printing unsorted elements: ", list);

        long begin = System.nanoTime();
        InsertionSort.sort(list);
        System.out.printf("Time elapsed: %f s", (System.nanoTime() - begin) / 1000000000.0);

        printListToUi("\nPrinting sorted elements: ", list);
    }

    // Function to sort list of doubles using Insertion Sort
    public static void sort(List<Double> list) {
        for (int indexOuterLoop = 1; indexOuterLoop < list.size(); ++indexOuterLoop) {
            double key = list.get(indexOuterLoop);
            int indexInnerLoop = indexOuterLoop - 1;

            // Move elements of list{0..indexOuterLoop-1}, that are
            // greater than key, to one position ahead
            // of their current position
            while (indexInnerLoop >= 0 && list.get(indexInnerLoop) > key)
                list.set(indexInnerLoop + 1, list.get(indexInnerLoop--));

            list.set(++indexInnerLoop, key);
        }
    }
}
