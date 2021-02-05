package com.programing.algorithms.sorting;

import java.util.List;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printIntegerListToUi;

/**
 * k = Range of Numbers in the list
 * <p>
 * Time Complexity
 * Best: O(n+k) Worst: O(n+k)   Avg: O(n+k)
 * <p>
 * Space Complexity: O(n+2^k)
 * Stable: Yes
 */
public class CountingSort {

    // Driver method
    public static void main(String[] args) {
        List<Integer> list = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", list);

        CountingSort.sort(list);

        printIntegerListToUi("Printing sorted elements: ", list);
    }

    // Function to sort list of integers using Counting Sort
    public static void sort(List<Integer> list) {
        int max = list.stream().max(Integer::compare).get();
        int min = list.stream().min(Integer::compare).get();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            count[list.get(i) - min]++;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        for (int i = list.size() - 1; i >= 0; i--) {
            output[count[list.get(i) - min] - 1] = list.get(i);
            count[list.get(i) - min]--;
        }

        for (int i = 0; i < list.size(); i++) {
            list.set(i, output[i]);
        }
    }
}