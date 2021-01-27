/**
 * Thanks to https://www.tutorialspoint.com/java/java_linkedhashmap_class.htm
 */
package com.programing.dataStructures.demos.currentStructures;

import java.util.*;

public class LinkedHashMapDemo {

    public static void main(String args[]) {
        // Create a hash map
        LinkedHashMap lhm = new LinkedHashMap();

        // Put elements to the map
        lhm.put("Zara", 3434.34);
        lhm.put("Mahnaz", 123.22);
        lhm.put("Ayan", 1378.00);
        lhm.put("Daisy", 99.22);
        lhm.put("Qadir", -19.08);

        // Get a set of the entries
        Set set = lhm.entrySet();

        System.out.printf(String.valueOf(set));

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
        double balance = ((Double) lhm.get("Zara")).doubleValue();
        lhm.put("Zara", Double.valueOf(balance + 1000));
        System.out.println("Zara's new balance: " + lhm.get("Zara"));
    }
}
