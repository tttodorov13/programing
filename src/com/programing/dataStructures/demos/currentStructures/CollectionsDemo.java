/**
 * Thanks to https://www.tutorialspoint.com/java/java_collection_interface.htm
 */
package com.programing.dataStructures.demos.currentStructures;

import java.util.*;

public class CollectionsDemo {

    public static void main(String[] args) {
        // ArrayList
        List a1 = new ArrayList();
        a1.add("Zara");
        a1.add("Mahnaz");
        a1.add("Ayan");
        System.out.println(" ArrayList Elements");
        System.out.print("\t" + a1);

        Collections.sort(a1);
        System.out.println();
        System.out.println(" ArrayList Elements Sorted");
        System.out.print("\t" + a1);

        // LinkedList
        List l1 = new LinkedList();
        l1.add("Zara");
        l1.add("Mahnaz");
        l1.add("Ayan");
        System.out.println();
        System.out.println(" LinkedList Elements");
        System.out.print("\t" + l1);

        // HashSet
        Set s1 = new HashSet();
        s1.add("Zara");
        s1.add("Mahnaz");
        s1.add("Ayan");
        System.out.println();
        System.out.println(" Set Elements");
        System.out.print("\t" + s1);

        // HashMap
        Map m1 = new HashMap();
        m1.put("Zara", "8");
        m1.put("Mahnaz", "31");
        m1.put("Ayan", "12");
        m1.put("Daisy", "14");
        System.out.println();
        System.out.println(" Map Elements");
        System.out.print("\t" + m1);

        // SortedSet
        SortedSet set = new TreeSet();
        set.add("b");
        set.add("c");
        set.add("a");
        Iterator it = set.iterator();
        System.out.println();
        System.out.println(" SortedSet Elements");
        System.out.print("\t" + set);

        // TreeMap
        TreeMap tm = new TreeMap();
        tm.put("Zara", Double.valueOf(3434.34));
        tm.put("Mahnaz", Double.valueOf(123.22));
        tm.put("Ayan", Double.valueOf(1378.00));
        tm.put("Daisy", Double.valueOf(99.22));
        tm.put("Qadir", Double.valueOf(-19.08));
        System.out.println();
        System.out.println(" TreeMap Elements");
        System.out.print("\t" + tm);
    }
}
