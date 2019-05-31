package com.programing.algorithms.searching;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		int[] a = { 16, 19, 20, 23, 45, 56, 78, 90, 96, 100 };
		System.out.printf("Print array: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		int item, location = -1;
		System.out.printf("\n\nEnter the item which you want to search: ");
		Scanner sc = new Scanner(System.in);
		item = sc.nextInt();
		location = binarySearch(a, 0, 9, item);
		if (location != -1) System.out.println("\nThe location of the item is " + location);
		else System.out.println("\nItem not found");
	}

	public static int binarySearch(int[] a, int beg, int end, int item) {
		int mid;
		if (end >= beg) {
			mid = (beg + end) / 2;
			if (a[mid] == item) {
				return mid + 1;
			} else if (a[mid] < item) {
				return binarySearch(a, mid + 1, end, item);
			} else {
				return binarySearch(a, beg, mid - 1, item);
			}
		}
		return -1;
	}
}
