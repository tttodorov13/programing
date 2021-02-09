package com.programing.algorithms.sorting;

import java.util.List;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printIntegerListToUi;

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
        List<Integer> list = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", list);

        ShellSort.sort(list);

        printIntegerListToUi("Printing sorted elements: ", list);
    }

    // Function to sort list of integers using Shell Sort
    public static void sort(List<Integer> list) {
        int n = list.size();

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = list.get(i);
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