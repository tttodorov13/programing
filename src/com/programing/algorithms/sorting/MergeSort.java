package com.programing.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

import static com.programing.algorithms.Utils.*;

/**
 * Best to sort linked list (constant extra space).
 * Best for very large number of
 * elements which cannot fit in
 * memory (External sorting)
 * <p>
 * Time Complexity
 * Best: O(N*lg(N))	Worst: O(N*lg(N))	Avg: O(N*lg(N))
 * <p>
 * Space Complexity: O(N*lg(N))
 * Stable: Yes
 */
public class MergeSort {

    // Driver method
    public static void main(String args[]) {
        List<Double> list = initializeDoubleList(args, true);

        printListToUi("Printing unsorted elements: ", list);

        long begin = System.nanoTime();
        MergeSort.sort(list, 0, list.size() - 1);
        System.out.printf("Time elapsed: %f s", (System.nanoTime() - begin) / 1000000000.0);

        printListToUi("\nPrinting sorted elements: ", list);
    }

    // Function to sort list of doubles using Merge Sort
    public static void sort(List<Double> list, int begin, int end) {
        if (begin < end) {
            // Find the middle point
            int middle = (begin + end) / 2;

            // Sort first and second halves
            sort(list, begin, middle);
            sort(list, middle + 1, end);

            // Merge the sorted halves
            merge(list, begin, middle, end);
        }
    }

    // Function merges two sub-lists of list.
    // First subarray is list{begin..middle}
    // Second subarray is list{middle+1..end}
    private static void merge(List<Double> list, int begin, int middle, int end) {
        // Find sizes of two sub-lists to be merged
        int sizeListBegin = middle - begin + 1;
        int sizeListEnd = end - middle;

        // Initial indexes of begin and end sub-lists
        int indexListBegin = 0;
        int indexListEnd = 0;

        // Initial index of merged sub-list
        int indexListMerged = begin;

        // Create temp arrays
        List<Double> listBegin = new ArrayList<>();
        List<Double> listEnd = new ArrayList<>();

        // Copy data to temp arrays
        while (indexListBegin < sizeListBegin)
            listBegin.add(list.get(begin + indexListBegin++));
        while (indexListEnd < sizeListEnd)
            listEnd.add(list.get(middle + 1 + indexListEnd++));

        // Merge the temp lists

        // Set indexes of begin and end sub-lists
        indexListBegin = 0;
        indexListEnd = 0;

        // Add elements from listBegin and listEnd ordered by size
        while (indexListBegin < sizeListBegin && indexListEnd < sizeListEnd)
            if (listBegin.get(indexListBegin) <= listEnd.get(indexListEnd))
                list.set(indexListMerged++, listBegin.get(indexListBegin++));
            else
                list.set(indexListMerged++, listEnd.get(indexListEnd++));

        // Copy remaining elements of listBegin if any.
        // Then increment index of merged sub-list and
        // increment index of begin sub-list
        while (indexListBegin < sizeListBegin)
            list.set(indexListMerged++, listBegin.get(indexListBegin++));

        // Copy remaining elements of listEbd if any.
        // Then increment index of merged sub-list and
        // increment index of end sub-list
        while (indexListEnd < sizeListEnd)
            list.set(indexListMerged++, listEnd.get(indexListEnd++));
    }
}
