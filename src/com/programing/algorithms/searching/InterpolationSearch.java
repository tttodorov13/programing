package com.programing.algorithms.searching;

import com.programing.algorithms.sorting.BubbleSortOptimized;

import java.util.List;
import java.util.Scanner;

import static com.programing.algorithms.Utils.initializeDoubleList;
import static com.programing.algorithms.Utils.printListToUi;

/**
 * Time Complexity
 * Best: O(lg2(lg2(N)))	Worst: O(N)   Avg: O(lg(N))
 * <p>
 * Space Complexity: O(1)
 * Stable: Yes
 */
public class InterpolationSearch {

    // Driver method
    public static void main(String[] args) {
        List<Double> list = initializeDoubleList(args, true);

        printListToUi("Printing elements: ", list);

        long begin = System.nanoTime();
        BubbleSortOptimized.sort(list);
        System.out.printf("Time elapsed: %f s", (System.nanoTime() - begin) / 1000000000.0);

        printListToUi("\nPrinting sorted elements: ", list);

        Scanner scanner = new Scanner(System.in);
        double item;
        int index = 0;

        while (index >= 0) {
            System.out.printf("\nEnter Item: ");
            item = scanner.nextDouble();

            begin = System.nanoTime();
            index = InterpolationSearch.search(list, 0, list.size() - 1, item);
            System.out.printf("Time elapsed: %f s", (System.nanoTime() - begin) / 1000000000.0);

            if (index >= 0)
                System.out.println("\nItem found at index: " + index);
            else
                System.out.println("\nItem not found!");
        }
    }

    // Function to search list of doubles using Interpolation Search
    public static int search(List<Double> list, int begin, int end, double item) {
        int pos;

        // Since array is sorted, an element
        // present in array must be in range
        // defined by corner
        if (begin <= end && item >= list.get(begin) && item <= list.get(end)) {

            // Probing the position with keeping
            // uniform distribution in mind.
            pos = begin
                    + ((end - begin) / ((int) (list.get(end) - list.get(begin))))
                    * ((int) (item - list.get(begin)));

            // Condition of target found
            if (list.get(pos) == item)
                return pos;

            // If item is smaller, item is in left sub list
            if (list.get(pos) > item)
                return search(list, begin, pos - 1, item);

            // If item is larger, item is in right sub list
            if (list.get(pos) < item)
                return search(list, pos + 1, end, item);
        }

        return -1;
    }
}
