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
    public static List<Integer> initializeIntegerList(String[] args) {
        return initializeIntegerList(args, false);
    }

    // Function to initialize integer list with or without negatives
    public static List<Integer> initializeIntegerList(String[] args, boolean hasNegatives) {
        List<Integer> a = new ArrayList<>();

        if (args.length == 0 || args[0] == null)
            a = generateRandomIntegerList(Double.valueOf(Math.random() * (Utils.MAX_SIZE - Utils.MIN_SIZE) + Utils.MIN_SIZE).intValue(), hasNegatives);
        else {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String[] stringArray = input.split(" ");
            for (String e : stringArray)
                a.add(Integer.valueOf(e));
        }

        return a;
    }

    // Function to initialize double list
    public static List<Double> initializeDoubleList(String[] args) {
        return initializeDoubleList(args, false);
    }

    // Function to initialize double list or without negatives
    public static List<Double> initializeDoubleList(String[] args, boolean hasNegatives) {
        List<Double> a = new ArrayList<>();

        if (args.length == 0 || args[0] == null)
            a = generateRandomDoubleList(Double.valueOf(Math.random() * (Utils.MAX_SIZE - Utils.MIN_SIZE) + Utils.MIN_SIZE).intValue(), hasNegatives);
        else {
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String[] stringArray = input.split(" ");
            for (String e : stringArray)
                a.add(Double.valueOf(e));
        }

        return a;
    }

    // Function to print list nicely
    public static void printListToUi(String message, List result) {
        System.out.printf(message);
        printList(result);
    }

    // Function to generate list of random integers
    private static List<Integer> generateRandomIntegerList(int size, boolean hasNegatives) {
        ArrayList<Integer> list = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++)
            if (hasNegatives)
                list.add(random.nextInt() % 2 == 0 ? random.nextInt(MAX) : -random.nextInt(MAX));
            else
                list.add(random.nextInt(MAX));

        return list;
    }

    // Function to generate list of random integers
    private static List<Double> generateRandomDoubleList(int size, boolean hasNegatives) {
        ArrayList<Double> list = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++)
            if (hasNegatives)
                list.add(random.nextInt() % 2 == 0 ? random.nextInt(MAX) - random.nextDouble() : -random.nextInt(MAX) + random.nextDouble());
            else
                list.add(Double.valueOf(random.nextInt(MAX) - random.nextDouble()));

        return list;
    }

    // Function to print list of numbers
    private static void printList(List arr) {
        for (int i = 0; i < arr.size(); ++i)
            if (arr.get(i) instanceof Integer)
                System.out.print(arr.get(i) + " ");
            else if (arr.get(i) instanceof Double)
                System.out.printf("%.2f ", arr.get(i));

        System.out.println();
    }
}
