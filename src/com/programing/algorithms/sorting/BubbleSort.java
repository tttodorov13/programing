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
        List<Integer> a = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", a);

        BubbleSort ob = new BubbleSort();
        ob.sort(a);

        printIntegerListToUi("Printing sorted elements: ", a);
    }

    // Function to sort list of integers using bubble sort
    public static List<Integer> sort(List<Integer> a) {
        int i, j, temp;
        for (i = 0; i < a.size(); i++) {
            for (j = 0; j < a.size(); j++) {
                if (a.get(i) < a.get(j)) {
                    temp = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, temp);
                }
            }
        }
        return a;
    }
}
