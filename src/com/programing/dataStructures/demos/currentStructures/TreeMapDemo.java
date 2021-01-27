/**
 * Thanks to https://www.tutorialspoint.com/java/java_treemap_class.htm
 */
package com.programing.dataStructures.demos.currentStructures;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String args[]) {
        // Create a hash map
        TreeMap tm = new TreeMap();

        // Put elements to the map
        tm.put("Zara", 3434.34);
        tm.put("Mahnaz", 123.22);
        tm.put("Ayan", 1378.00);
        tm.put("Daisy", 99.22);
        tm.put("Qadir", -19.08);

        // Get a set of the entries
        Set set = tm.entrySet();

        // Get an iterator
        Iterator i = set.iterator();

        // Display elements
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        // Deposit 1000 into Zara's account
        double balance = ((Double) tm.get("Zara")).doubleValue();
        tm.put("Zara", Double.valueOf(balance + 1000));
        System.out.println("Zara's new balance: " + tm.get("Zara"));

        // Create a new hash map
        TreeMap newTm = new TreeMap();
        newTm.put(3434.34, "Zara");
        newTm.put(123.22, "Mahnaz");
        newTm.put(1378.00, "Ayan");
        newTm.put(99.22, "Daisy");
        newTm.put(-19.08, "Qadir");

        // Get a set of the entries
        Set newSet = newTm.entrySet();

        // Get an iterator
        Iterator newI = newSet.iterator();

        // Display elements
        while (newI.hasNext()) {
            Map.Entry me = (Map.Entry) newI.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();
    }
}
