package com.programing.algorithms.sorting;

import java.util.List;
import java.util.Random;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printListToUi;

/**
 * Pivot chosen randomly
 * <p>
 * Time Complexity
 * Best: O(n*lg(n))	Worst: O(n*2))	Avg: O(n*lg(n))
 * <p>
 * Space Complexity: O(1)
 * Stable: Yes
 */
public class RandomizedQuickSort {

    // Driver method
    public static void main(String[] args) {
        List<Integer> list = initializeIntegerList(args, true);

        printListToUi("Printing unsorted elements: ", list);

        long begin = System.nanoTime();
        RandomizedQuickSort.sort(list, 0, list.size() - 1);
        System.out.printf("Time elapsed: %f s", (System.nanoTime() - begin) / 1000000000.0);

        printListToUi("\nPrinting sorted elements: ", list);
    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    private static int partition(List<Integer> a, int low, int high) {
        // pivot is chosen randomly
        Random random = new Random();
        int pivot = random.nextInt(high - low) + low;
        int temp;

        temp = a.get(pivot);
        a.set(pivot, a.get(high));
        a.set(high, temp);
        pivot = a.get(high);

        int i = (low - 1);  // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (a.get(j) < pivot) {
                i++;

                // swap a.get(i) and a.get(j)
                temp = a.get(i);
                a.set(i, a.get(j));
                a.set(j, temp);
            }
        }

        // swap a.get(i+1) and a.get(high) (or pivot)
        temp = a.get(i + 1);
        a.set(i + 1, a.get(high));
        a.set(high, temp);

        return i + 1;
    }

    /* The main function that implements Randomized Quick Sort
      a --> List to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public static void sort(List<Integer> a, int low, int high) {
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
