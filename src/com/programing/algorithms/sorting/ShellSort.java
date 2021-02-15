package com.programing.algorithms.sorting;

import java.util.List;

import static com.programing.algorithms.Utils.*;

/**
 * For each pair of indices, swap the
 * elements if they are out of order
 * <p>
 * Time Complexity
 * Best: O(N)	Worst: O(N)	Avg: O(N)
 * <p>
 * Space Complexity: O(N)
 * Stable: No
 */
public class ShellSort {

    // Driver method
    public static void main(String[] args) {
        List<Double> list = initializeDoubleList(args, true);

        printListToUi("Printing unsorted elements: ", list);

        long begin = System.nanoTime();
        ShellSort.sort(list);
        System.out.printf("Time elapsed: %f s", (System.nanoTime() - begin) / 1000000000.0);

        printListToUi("\nPrinting sorted elements: ", list);
    }

    // Function to sort list of doubles using Shell Sort
    public static void sort(List<Double> list) {
        // In this particular case the gap is half the size of the list
        for (int gap = list.size() / 2; gap > 0; gap /= 2) {
            for (int indexOuterLoop = gap; indexOuterLoop < list.size(); indexOuterLoop++) {
                double key = list.get(indexOuterLoop);
                int indexInnerLoop = indexOuterLoop;

                // Move elements of list{0..indexOuterLoop-gap}, that are
                // greater than key, to the position plus gap ahead
                // of their current position
                while (indexInnerLoop >= gap && list.get(indexInnerLoop - gap) > key) {
                    list.set(indexInnerLoop, list.get(indexInnerLoop - gap));
                    indexInnerLoop -= gap;
                }

                list.set(indexInnerLoop, key);
            }
        }
    }
}