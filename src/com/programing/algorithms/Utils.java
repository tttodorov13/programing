package com.programing.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Class containing common parameters and utility functions
 */
public class Utils {
    private static int MIN_SIZE = 1;
    private static int MAX_SIZE = 10;
    private static int MAX = 1000;

    // Function to initialize integer list
    public static char[] initializeCharArray(String[] args) {
        char[] a;

        if (args.length == 0 || args[0] == null)
            a = generateRandomCharArray(Double.valueOf(Math.random() * (Utils.MAX_SIZE - Utils.MIN_SIZE) + Utils.MIN_SIZE).intValue());
        else {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String[] stringArray = input.split(" ");
            a = new char[stringArray.length];
            for (int i = 0; i < stringArray.length; i++)
                a[i] = stringArray[i].charAt(0);
        }

        return a;
    }

    // Function to initialize integer list
    public static List<Integer> initializeIntegerList(String[] args) {
        List<Integer> a = new ArrayList<>();

        if (args.length == 0 || args[0] == null)
            a = generateRandomIntegerList(Double.valueOf(Math.random() * (Utils.MAX_SIZE - Utils.MIN_SIZE) + Utils.MIN_SIZE).intValue());
        else {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String[] stringArray = input.split(" ");
            for (String e : stringArray)
                a.add(Integer.valueOf(e));
        }

        return a;
    }

    // Function to print integer list nicely
    public static void printCharArrayToUi(String message, char[] result) {
        System.out.printf(message);
        printCharArray(result);
    }

    // Function to print integer list nicely
    public static void printIntegerListToUi(String message, List<Integer> result) {
        System.out.printf(message);
        printIntegerList(result);
    }

    // Function to generate list of random integers
    private static char[] generateRandomCharArray(int size) {
        char a[] = new char[size];
        Random random = new Random();

        for (int i = 0; i < size; i++)
            a[i] = (char) (random.nextInt(26) + 'a');

        return a;
    }

    // Function to generate list of random integers
    private static List<Integer> generateRandomIntegerList(int size) {
        ArrayList<Integer> list = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++)
            list.add(random.nextInt(MAX));

        return list;
    }

    // Function to print list of integers
    private static void printCharArray(char[] arr) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Function to print list of integers
    private static void printIntegerList(List<Integer> arr) {
        for (int i = 0; i < arr.size(); ++i)
            System.out.print(arr.get(i) + " ");

        System.out.println();
    }
}
