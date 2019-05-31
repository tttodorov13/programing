package com.programing.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printIntegerListToUi;

/**
 * Best to sort linked list (constant
 * extra space).
 * Best for very large number of
 * elements which cannot fit in
 * memory (External sorting)
 * <p>
 * Time Complexity
 * Best: O(n*lg(n))	Worst: O(n*lg(n))	Avg: O(n*lg(n))
 * <p>
 * Space Complexity: O(n)
 * Stable: Yes
 */
public class MergeSort {

    // Driver method
    public static void main(String args[]) {
        List<Integer> a = initializeIntegerList(args);

        printIntegerListToUi("Printing unsorted elements: ", a);

        MergeSort ob = new MergeSort();
        ob.sort(a, 0, a.size() - 1);

        printIntegerListToUi("Printing sorted elements: ", a);
    }

    // Function merges two sub-lists of a.
    // First subarray is a{beg..med}
    // Second subarray is a{med+1..end}
    private void merge(List<Integer> a, int beg, int med, int end) {
        // Find sizes of two sub-lists to be merged
        int n1 = med - beg + 1;
        int n2 = end - med;

        // Create temp arrays
        List<Integer> Beg = new ArrayList<>();
        List<Integer> End = new ArrayList<>();

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            Beg.add(i, a.get(beg + i));
        for (int j = 0; j < n2; ++j)
            End.add(j, a.get(med + 1 + j));

        // Merge the temp lists

        // Initial indexes of first and second sub-lists
        int i = 0, j = 0;

        // Initial index of merged sub-list
        int k = beg;
        while (i < n1 && j < n2) {
            if (Beg.get(i) <= End.get(j)) {
                a.set(k, Beg.get(i));
                i++;
            } else {
                a.set(k, End.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining elements of Beg if any
        while (i < n1) {
            a.set(k, Beg.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of End if any
        while (j < n2) {
            a.set(k, End.get(j));
            j++;
            k++;
        }
    }

    // Function to sort list of integers using merge sort
    void sort(List<Integer> a, int beg, int end) {
        if (beg < end) {
			// Find the middle point
            int mid = (beg + end) / 2;

			// Sort first and second halves
            sort(a, beg, mid);
            sort(a, mid + 1, end);

			// Merge the sorted halves
            merge(a, beg, mid, end);
        }
    }
}
