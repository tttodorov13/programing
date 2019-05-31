package com.programing.algorithms.searching;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		int[] a = { 10, 23, 15, 8, 4, 3, 25, 30, 34, 2, 19 };
		System.out.printf("Print array: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		int item, flag = 0;
		Scanner sc = new Scanner(System.in);
		System.out.printf("\n\nEnter Item: ");
		item = sc.nextInt();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == item) {
				flag = i + 1;
				break;
			} else flag = 0;
		}
		if (flag != 0) {
			System.out.println("\nItem found at location: " + flag);
		} else System.out.println("\nItem not found!");
	}
}
