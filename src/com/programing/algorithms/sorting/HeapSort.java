package com.programing.algorithms.sorting;

import java.util.List;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printIntegerListToUi;

/**
 * Time Complexity
 * Best: O(n*lg(n))	Worst: O(n*lg(n))   Avg: O(n*lg(n))
 * <p>
 * Space Complexity: O(1)
 * Stable: No
 */
public class HeapSort {

    // Driver method
    public static void main(String[] args) {
        List<Integer> list = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", list);

        HeapSort.sort(list);

        printIntegerListToUi("Printing sorted elements: ", list);
    }

    // To heapify list subtree rooted with node i which is
    // an index in list. n is size of heap
    private static void heapify(List<Integer> list, int n, int i) {
        int largest = i;    // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && list.get(l) > list.get(largest))
            largest = l;

        // If right child is larger than largest so far
        if (r < n && list.get(r) > list.get(largest))
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, swap);

            // Recursively heapify the affected sub-tree
            heapify(list, n, largest);
        }
    }

    // Function to sort list of integers using Heap Sort
    public static void sort(List<Integer> a) {
        int n = a.size();

        // Build heap (rearrange list)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(a, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = a.get(0);
            a.set(0, a.get(i));
            a.set(i, temp);

            // call max heapify on the reduced heap
            heapify(a, i, 0);
        }
    }
}
