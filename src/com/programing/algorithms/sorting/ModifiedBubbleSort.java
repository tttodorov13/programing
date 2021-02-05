package com.programing.algorithms.sorting;

import java.util.List;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printIntegerListToUi;

/**
 * For each pair of indices, swap the
 * elements if they are out of order
 * At each Pass check if the Array is
 * already sorted Best Case-Array
 * Already sorted
 * <p>
 * Time Complexity
 * Best: O(n)	Worst: O(n^2)	Avg: O(n^2)
 * <p>
 * Space Complexity: O(1)
 * Stable: Yes
 */
public class ModifiedBubbleSort {

    // Driver method
    public static void main(String[] args) {
        List<Integer> list = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", list);

        ModifiedBubbleSort.sort(list);

        printIntegerListToUi("Printing sorted elements: ", list);
    }

    // Function to sort list of integers using Modified Bubble Sort
    public static List<Integer> sort(List<Integer> list) {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < list.size(); i++) {
            swapped = false;
            for (j = 0; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
        return list;
    }
}
