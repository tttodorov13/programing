package com.programing.algorithms.sorting;

import java.util.*;

import static com.programing.algorithms.Utils.initializeIntegerList;
import static com.programing.algorithms.Utils.printListToUi;

/**
 * K - Range of Numbers in the list.
 * K = 10
 * <p>
 * Time Complexity
 * Best: O(N*K/S)   Worst: O(2^S*N*K/S) Avg: O(NlgK)
 * <p>
 * Space Complexity: O(NlgK)
 * Stable: No
 */
public class RadixSort {

    // Driver method
    public static void main(String[] args) {
        List<Integer> list = initializeIntegerList(args);

        printListToUi("Printing unsorted elements: ", list);

        RadixSort.sort(list);

        printListToUi("Printing sorted elements: ", list);
    }

    // Function to sort list of integers using Radix Sort
    private static void sort(List<Integer> list) {
        // Find the maximum element in the list
        int maxElement = list.stream().max(Integer::compare).get();
        // Find the minimum element in the list
        int minElement = list.stream().min(Integer::compare).get();

        // Find the maximum number of digits
        int maxDigits = getNumberOfDigits(maxElement) >= getNumberOfDigits(minElement) ? getNumberOfDigits(maxElement) : getNumberOfDigits(minElement);

        // Sort the list consequently, digit by digit
        List listClone = list;
        for (int digit = 1; digit <= maxDigits; digit++)
            listClone = countingSort(listClone, digit);

        list.clear();
        list.addAll(listClone);
    }

    // Modify the Counting Sort to get parameter, digit through which to be sorted
    private static List<Integer> countingSort(List<Integer> list, int digit) {
        // Create an array to store numbers' repetitions
        // for the digits 0 through 9
        int digitRepetitions[] = new int[10];
        // Create an array to store the numbers ordered
        Integer result[] = new Integer[list.size()];

        // Count each number's repetitions
        for (int i = 0; i < list.size(); i++)
            digitRepetitions[kthDigit(list.get(i), digit)]++;

        // Calculate the last position of any element
        // by adding the number of all elements before it
        for (int i = 1; i < digitRepetitions.length; i++)
            digitRepetitions[i] += digitRepetitions[i - 1];

        // Write elements ordered in the array
        for (int i = list.size() - 1; i >= 0; i--) {
            int num = list.get(i);
            // Take a digit of each number and
            // look for the number position in the array
            int numDigit = kthDigit(num, digit);
            digitRepetitions[numDigit]--;
            int pos = digitRepetitions[numDigit];
            result[pos] = num;
        }

        return Arrays.asList(result);
    }

    // Function to take the digit from number on position
    private static int kthDigit(int number, int k) {
        // Calculate 10 of power к-1 to remove leading k-1 digits
        int tenOnKth = (int) Math.pow(10, k - 1);
        // Divide and return к-th digit as result
        return (number / tenOnKth) % 10;
    }

    // Function to return number of digits in an integer
    private static int getNumberOfDigits(Integer num) {
        int digits = 0;
        while (num > 0) {
            num /= 10;
            digits++;
        }

        return digits;
    }
}