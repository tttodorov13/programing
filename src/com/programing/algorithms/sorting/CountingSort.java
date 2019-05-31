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
        List<Integer> a = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", a);

        CountingSort ob = new CountingSort();
        ob.sort(a);

        printIntegerListToUi("Printing sorted elements: ", a);

    }

    // Function to sort list of integers using counting sort
    public void sort(List<Integer> a) {
        int max = a.stream().max(Integer::compare).get();
        int min = a.stream().min(Integer::compare).get();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[a.size()];
        for (int i = 0; i < a.size(); i++)
            count[a.get(i) - min]++;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        for (int i = a.size() - 1; i >= 0; i--) {
            output[count[a.get(i) - min] - 1] = a.get(i);
            count[a.get(i) - min]--;
        }

        for (int i = 0; i < a.size(); i++) {
            a.set(i, output[i]);
        }
    }
}