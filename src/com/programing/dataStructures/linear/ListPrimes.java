package com.programing.dataStructures.linear;

import java.util.ArrayList;

public class ListPrimes {

	public static ArrayList<Integer> getPrimes(int start, int end) {
		ArrayList<Integer> primesList = new ArrayList<Integer>();
		for (int num = start; num <= end; num++) {
			boolean prime = true;
			for (int div = 2; div <= Math.sqrt(num); div++) {
				if (num % div == 0) {
					prime = false;
					break;
				}
			}
			if (prime) primesList.add(num);
		}
		return primesList;
	}

	public static void main(String[] args) {
		ArrayList<Integer> primes = getPrimes(1, 100);
		for (int p : primes) {
			System.out.printf("%d ", p);
		}
		System.out.println();
	}

}
