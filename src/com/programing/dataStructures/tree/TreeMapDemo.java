package com.programing.dataStructures.tree;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * This class demonstrates using of {@link TreeMap} class.
 */
public class TreeMapDemo {

	private static final String TEXT = "Test text words Count " + "words count test";

	Comparator<String> caseInsensitiveComparator = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			return o1.compareToIgnoreCase(o2);
		}
	};

	public static void main(String[] args) {
		Map<String, Integer> wordsCounts = createWordsCounts(TEXT);
		Map<String, Integer> wordsCountsIgnoreCase = createWordsCountsIgnoreCase(TEXT);
		printWordsCount(wordsCounts);
		System.out.println();
		printWordsCount(wordsCountsIgnoreCase);
	}

	private static Map<String, Integer> createWordsCounts(String text) {
		Scanner textScanner = new Scanner(text);
		Map<String, Integer> words = new TreeMap<String, Integer>();
		while (textScanner.hasNext()) {
			String word = textScanner.next();
			Integer count = words.get(word);
			if (count == null) {
				count = 0;
			}
			words.put(word, count + 1);
		}
		return words;
	}

	private static Map<String, Integer> createWordsCountsIgnoreCase(String text) {
		Scanner textScanner = new Scanner(text);
		Map<String, Integer> wordsIgnoreCase = new TreeMap<String, Integer>(String::compareToIgnoreCase);
		while (textScanner.hasNext()) {
			String word = textScanner.next();
			Integer count = wordsIgnoreCase.get(word);
			if (count == null) {
				count = 0;
			}
			wordsIgnoreCase.put(word, count + 1);
		}
		return wordsIgnoreCase;
	}

	private static void printWordsCount(Map<String, Integer> wordsCounts) {
		for (Map.Entry<String, Integer> wordEntry : wordsCounts.entrySet()) {
			System.out.printf("word '%s' is seen %d times in the text%n", wordEntry.getKey(), wordEntry.getValue());
		}
	}
}
