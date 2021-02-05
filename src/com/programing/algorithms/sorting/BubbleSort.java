package com.programing.algorithms.sorting;

import java.util.List;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printIntegerListToUi;

/**
 * For each pair of indices, swap the
 * elements if they are out of order
 * <p>
 * Time Complexity
 * Best: O(n^2)	Worst: O(n^2)	Avg: O(n^2)
 * <p>
 * Space Complexity: O(1)
 * Stable: Yes
 */
public class BubbleSort {

    // Driver method
    public static void main(String[] args) {
        List<Integer> list = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", list);

        BubbleSort.sort(list);

        printIntegerListToUi("Printing sorted elements: ", list);
    }

    // Function to sort list of integers using bubble sort
    public static List<Integer> sort(List<Integer> list) {
        int i, j, temp;
        for (i = 0; i < list.size(); i++) {
            for (j = 0; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }
}
