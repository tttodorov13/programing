package com.programing.algorithms.sorting;

import java.util.Collections;
import java.util.List;

import static com.programing.algorithms.Utils.*;

/**
 * <b>Best Case:<b/>
 * When pivot divide in 2 equal halves
 * <b>Worst Case:</b>
 * List already sorted 1/n-1 partition
 * <p>
 * Time Complexity
 * Best: O(N*lg(N))	Worst: O(N*lg(N))	Avg: O(N*lg(N))
 * <p>
 * Space Complexity: O(N)
 * Stable: Yes
 */
public class QuickSort {

    // Driver method
    public static void main(String[] args) {
        List<Double> list = initializeDoubleList(args, true);

        printListToUi("Printing unsorted elements: ", list);

        long begin = System.nanoTime();
        QuickSort.sort(list, 0, list.size() - 1);
        System.out.printf("Time elapsed: %f s", (System.nanoTime() - begin) / 1000000000.0);

        printListToUi("\nPrinting sorted elements: ", list);
    }

    // Function to sort list of doubles using Quick Sort
    // list --> List to be sorted,
    // low  --> Starting index,
    // high  --> Ending index
    public static void sort(List<Double> list, int low, int high) {
        if (low < high) {
            // indexPartitioning is partitioning index,
            // list.get(indexPartitioning) is
            // now at right place
            int indexPartitioning = partition(list, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(list, low, indexPartitioning - 1);
            sort(list, indexPartitioning + 1, high);
        }
    }

    // Function to take last element as pivot,
    // places the pivot element at its correct
    // position in sorted list, and places all
    // smaller (smaller than pivot) to left of
    // pivot and all greater elements to right
    // of pivot
    private static int partition(List<Double> list, int low, int high) {
        // index of smaller element
        int indexSmallerElement = low - 1;
        for (int indexCurrentElement = low; indexCurrentElement < high; indexCurrentElement++)
            // If current element is smaller than the pivot "list.get(high)"
            if (list.get(indexCurrentElement) < list.get(high))
                // swap list.get(indexSmallerElement) and list.get(indexCurrentElement)
                Collections.swap(list, ++indexSmallerElement, indexCurrentElement);

        // swap list.get(++indexSmallerElement) and the pivot "list.get(high)"
        Collections.swap(list, ++indexSmallerElement, high);

        return indexSmallerElement;
    }
}
