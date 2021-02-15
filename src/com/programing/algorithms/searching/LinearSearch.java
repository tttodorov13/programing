package com.programing.algorithms.searching;

import java.util.List;
import java.util.Scanner;

import static com.programing.algorithms.Utils.initializeDoubleList;
import static com.programing.algorithms.Utils.printListToUi;

/**
 * Time Complexity
 * Best: O(0)	Worst: O(N)   Avg: O(N)
 * <p>
 * Space Complexity: O(N)
 * Stable: Yes
 */
public class LinearSearch {

    // Driver method
    public static void main(String[] args) {
        List<Double> list = initializeDoubleList(args, true);

        printListToUi("Printing elements: ", list);

        Scanner scanner = new Scanner(System.in);
        Object item;
        int index = 0;

        while (index >= 0) {
            System.out.printf("\nEnter Item: ");
            item = scanner.nextDouble();

            long begin = System.nanoTime();
            index = LinearSearch.search(list, item);
            System.out.printf("Time elapsed: %f s", (System.nanoTime() - begin) / 1000000000.0);

            if (index >= 0)
                System.out.println("\nItem found at index: " + index);
            else
                System.out.println("\nItem not found!");
        }
    }

    // Function to search list of doubles using Linear Search
    public static int search(List list, Object o) {
        for (int i = 0; i < list.size() - 1; i++)
            // If found return its first index
            if (o.equals(list.get(i)))
                return i;

        // If not found return -1
        return -1;
    }
}
