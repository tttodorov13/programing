package com.programing.algorithms.sorting;

import java.util.List;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printIntegerListToUi;

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
        List<Integer> list = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", list);

        SelectionSortOptimized.sort(list);

        printIntegerListToUi("Printing sorted elements: ", list);
    }

    // Function to sort list of integers using Selection Sort
    public static void sort(List<Integer> list) {
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
            for (int index = start; index <= end; index++) {
                if (list.get(index) > list.get(maxIndex))
                    maxIndex = index;
                if (list.get(index) < list.get(minIndex))
                    minIndex = index;
            }

            // Swap the found maximum element with the last element
            int temp = list.get(maxIndex);
            list.set(maxIndex, end);
            list.set(end, temp);

            // If at the end is the minimum element fix minIndex
            // because it is already on the position of maxIndex
            if (minIndex == end)
                minIndex = maxIndex;

            // Swap the found minimum element with the first element
            temp = list.get(minIndex);
            list.set(minIndex, start);
            list.set(start, temp);

            // Move the end and start by 1
            // by shrinking with 1 element
            // in order to search the next largest and smallest
            end--;
            start++;
        }
    }
}
