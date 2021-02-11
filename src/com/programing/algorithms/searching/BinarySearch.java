package com.programing.algorithms.searching;

import com.programing.algorithms.sorting.BubbleSortOptimized;

import java.util.List;
import java.util.Scanner;

import static com.programing.algorithms.Utils.initializeDoubleList;
import static com.programing.algorithms.Utils.printListToUi;

/**
 * Time Complexity
 * Best: O(lg(N))	Worst: O(lg(N)+1)   Avg: O(lg(N))
 * <p>
 * Space Complexity: O(N)
 * Stable: Yes
 */
public class BinarySearch {

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
            index = search(list, 0, list.size() - 1, item);
            System.out.printf("Time elapsed: %f s", (System.nanoTime() - begin) / 1000000000.0);

            if (index >= 0)
                System.out.println("\nItem found at index: " + index);
            else
                System.out.println("\nItem not found!");
        }
    }

    // Function to binary search for element
    public static int search(List<Double> list, int begin, int end, double item) {
        if (end >= begin) {
            // Find the middle element
            int mid = (begin + end) / 2;

            if (list.get(mid).equals(item))
                return mid;
            else if (list.get(mid) < item)
                return search(list, mid + 1, end, item);
            else
                return search(list, begin, mid - 1, item);
        }

        return -1;
    }
}
