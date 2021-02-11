package com.programing.algorithms.sorting;

import java.util.List;

import static com.programing.algorithms.Utils.*;

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
        List<Double> list = initializeDoubleList(args, true);

        printListToUi("Printing unsorted elements: ", list);

        long begin = System.nanoTime();
        QuickSort.sort(list, 0, list.size() - 1);
        System.out.printf("Time elapsed: %f s", (System.nanoTime() - begin) / 1000000000.0);

        printListToUi("\nPrinting sorted elements: ", list);
    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    private static int partition(List<Double> list, int low, int high) {
        double pivot = list.get(high);
        double temp;

        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (list.get(j) < pivot) {
                i++;

                // swap list.get(i) and list.get(j)
                temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        // swap list.get(i+1) and list.get(high) (or pivot)
        temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }

    /* The main function that implements Quick Sort
      a --> List to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public static void sort(List<Double> a, int low, int high) {
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
