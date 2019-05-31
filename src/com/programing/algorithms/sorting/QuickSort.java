package com.programing.algorithms.sorting;

import java.util.List;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printIntegerListToUi;

/**
 * <b>Best Case:<b/> When pivote divide in 2
 * equal halves
 * <b>Worst Case:</b> Array already sorted -
 * 1/n-1 partition
 * <p>
 * Time Complexity
 * Best: O(n*lg(n))	Worst: O(n*lg(n))	Avg: O(n*lg(n))
 * <p>
 * Space Complexity: O(1)
 * Stable: Yes
 */
public class QuickSort {

    // Driver method
    public static void main(String[] args) {
        List<Integer> a = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", a);

        QuickSort ob = new QuickSort();
        ob.sort(a, 0, a.size() - 1);

        printIntegerListToUi("Printing sorted elements: ", a);
    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    private static int partition(List<Integer> a, int low, int high) {
        int pivot = a.get(high);

        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (a.get(j) < pivot) {
                i++;

                // swap a.get(i) and a.get(j)
                int temp = a.get(i);
                a.set(i, a.get(j));
                a.set(j, temp);
            }
        }

        // swap a.get(i+1) and a.get(high) (or pivot)
        int temp = a.get(i + 1);
        a.set(i + 1, a.get(high));
        a.set(high, temp);

        return i + 1;
    }

    /* The main function that implements QuickSort()
      a --> List to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(List<Integer> a, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(a, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(a, low, pi - 1);
            sort(a, pi + 1, high);
        }
    }
}
