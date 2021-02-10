package com.programing.algorithms.sorting;

import java.util.Collections;
import java.util.List;

import static com.programing.algorithms.Utils.*;

/**
 * Time Complexity
 * Best: O(N*lg(N))	Worst: O(N*lg(N))   Avg: O(N*lg(N))
 * <p>
 * Space Complexity: O(Nlg(N))
 * Stable: No
 */
public class HeapSort {

    // Driver method
    public static void main(String[] args) {
        List<Double> list = initializeDoubleList(args, true);

        printListToUi("Printing unsorted elements: ", list);

        HeapSort.sort(list);

        printListToUi("Printing sorted elements: ", list);
    }

    // Function to sort list of doubles using Heap Sort
    public static void sort(List<Double> list) {
        int listSize = list.size();

        // Build heap (rearrange list)
        for (int i = listSize / 2 - 1; i >= 0; i--)
            heapify(list, listSize, i);

        // One by one extract an element from heap
        for (int i = listSize - 1; i >= 0; i--) {
            // Move current root to end
            Collections.swap(list, i, 0);

            // call max heapify on the reduced heap
            heapify(list, i, 0);
        }
    }

    // To heapify list subtree rooted with node index
    // which is an index in list; listSize is size of heap
    private static void heapify(List<Double> list, int listSize, int index) {
        int largest = index;    // Initialize largest as root
        int l = 2 * index + 1;  // left = 2*index + 1
        int r = 2 * index + 2;  // right = 2*index + 2

        // If left child is larger than root
        if (l < listSize && list.get(l) > list.get(largest))
            largest = l;

        // If right child is larger than largest so far
        if (r < listSize && list.get(r) > list.get(largest))
            largest = r;

        // If largest is not root
        if (largest != index) {
            // Move largest up
            Collections.swap(list, index, largest);

            // Recursively heapify the affected sub-tree
            heapify(list, listSize, largest);
        }
    }
}
