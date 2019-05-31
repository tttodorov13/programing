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
 *
 * Time Complexity
 * Best: O(n)	Worst: O(n^2)	Avg: O(n^2)
 *
 * Space Complexity: O(1)
 * Stable: Yes
 */
public class ModifiedBubbleSort {

    // Driver method
    public static void main(String[] args) {
        List<Integer> a = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", a);

        ModifiedBubbleSort ob = new ModifiedBubbleSort();
        ob.sort(a);

        printIntegerListToUi("Printing sorted elements: ", a);
    }

    // Function to sort list of integers using modified bubble sort
    public static List<Integer> sort(List<Integer> a) {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < a.size(); i++) {
            swapped = false;
            for (j = 0; j < a.size(); j++) {
                if (a.get(i) < a.get(j)) {
                    temp = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, temp);
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
        return a;
    }
}
