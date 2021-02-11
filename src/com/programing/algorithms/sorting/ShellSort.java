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
 * Stable: N/A
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
        int n = list.size();

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                double key = list.get(i);
                int j = i;
                while (j >= gap && list.get(j - gap) > key) {
                    list.set(j, list.get(j - gap));
                    j -= gap;
                }
                list.set(j, key);
            }
        }
    }
}