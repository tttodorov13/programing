package com.programing.algorithms.sorting;

import java.util.Arrays;
import java.util.List;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printListToUi;

/**
 * K - range of Numbers in the list
 * <p>
 * Time Complexity
 * Best: O(N+K) Worst: O(N+K)   Avg: O(N+K)
 * <p>
 * Space Complexity: O(N+2^K)
 * Stable: Yes
 */
public class CountingSort {

    // Driver method
    public static void main(String[] args) {
        List<Integer> list = initializeIntegerList(args, true);

        printListToUi("Printing unsorted elements: ", list);

        long begin = System.nanoTime();
        CountingSort.sort(list);
        System.out.printf("Time elapsed: %f s", (System.nanoTime() - begin) / 1000000000.0);

        printListToUi("\nPrinting sorted elements: ", list);
    }

    // Function to sort list of integers using Counting Sort
    public static void sort(List<Integer> list) {
        // Find the maximum element in the list
        int maxElement = list.stream().max(Integer::compare).get();
        // Find the minimum element in the list
        int minElement = list.stream().min(Integer::compare).get();
        // Find the lowest count of numbers
        // in which to look for repetitions
        int range = maxElement - minElement + 1;
        // Create an array to store numbers' repetitions
        int countRepetitions[] = new int[range];
        // Create an array to store the numbers ordered
        Integer result[] = new Integer[list.size()];

        // Count each number's repetitions
        for (int i = 0; i < list.size(); i++)
            countRepetitions[list.get(i) - minElement]++;

        // Calculate the final position of any element
        // by adding the count of all elements before it
        for (int i = 1; i < countRepetitions.length; i++)
            countRepetitions[i] += countRepetitions[i - 1];

        // Write numbers ordered in the array
        for (int i = list.size() - 1; i >= 0; i--)
            result[countRepetitions[list.get(i) - minElement]-- - 1] = list.get(i);

        // Write numbers ordered to the list
        list.clear();
        list.addAll(Arrays.asList(result));
    }
}