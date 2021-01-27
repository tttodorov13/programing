package com.programing.dataStructures.demos.oldStructures;

import java.util.HashMap;

public class DictionaryDemo {

    static void showPut(HashMap dictionary, String key, int value) {
        dictionary.put(key, value);
        System.out.println("put(" + key + ", " + value + ")");
        System.out.println("dictionary: " + dictionary);
    }

    static void showGet(HashMap dictionary, String key) {
        System.out.println("dictionary: " + dictionary);
        System.out.printf("get(%s) -> ", key);
        Integer value = (Integer) dictionary.get(key);
        System.out.println(value);
    }

    public static void main(String args[]) {
        HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
        System.out.println("dictionary: " + dictionary);
        showPut(dictionary, "a", 42);
        showPut(dictionary, "b", 66);
        showPut(dictionary, "c", 99);
        showGet(dictionary, "a");
        showGet(dictionary, "b");
        showGet(dictionary, "c");
        try {
            showGet(dictionary, "d");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
