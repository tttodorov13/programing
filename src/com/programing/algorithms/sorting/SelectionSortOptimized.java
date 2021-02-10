package com.programing.algorithms.sorting;

import java.util.Collections;
import java.util.List;

import static com.programing.algorithms.Utils.*;

/**
 * Swap happens only when once in
 * a Single pass
 * <p>
 * Time Complexity
 * Best: O(n/2)	Worst: O(n^2)	Avg: O(n^2)
 * <p>
 * Space Complexity: O(n)
 * Stable: Yes
 */
public class SelectionSortOptimized {

    // Driver method
    public static void main(String[] args) {
        List<Double> list = initializeDoubleList(args, true);

        printListToUi("Printing unsorted elements: ", list);

        SelectionSortOptimized.sort(list);

        printListToUi("Printing sorted elements: ", list);
    }

    // Function to sort list of doubles using Selection Sort
    public static void sort(List<Double> list) {
        // Mark from where till where list is sorted
        int start = 0;
        int end = list.size() - 1;

        // Move boundaries of unsorted subarray by an element from each side
        for (int sortedCount = 0; sortedCount < list.size() / 2; sortedCount++) {
            // Store positions of largest and smallest
            // supposing they are in the beginning
            // of the unsorted list
            int maxIndex = start;
            int minIndex = start;

            // Find the indexes of the largest and smallest element
            for (int currentIndex = start; currentIndex <= end; currentIndex++) {
                if (list.get(currentIndex) > list.get(maxIndex))
                    maxIndex = currentIndex;
                if (list.get(currentIndex) < list.get(minIndex))
                    minIndex = currentIndex;
            }

            // Swap the found maximum element with the last element
            Collections.swap(list, maxIndex, end);

            // If at the end is the minimum element fix minIndex
            // because it is already on the position of maxIndex
            if (minIndex == end)
                minIndex = maxIndex;

            // Swap the found minimum element with the first element
            Collections.swap(list, minIndex, start);

            // Move the end and start by 1
            // by shrinking with 1 element
            // in order to search the next largest and smallest
            end--;
            start++;
        }
    }
}
