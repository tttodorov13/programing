/**
 * Thanks to https://www.tutorialspoint.com/java/java_treeset_class.htm
 */
package com.programing.dataStructures.demos.currentStructures;

import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String args[]) {
        // Create a tree set
        TreeSet ts = new TreeSet();

        // Add elements to the tree set
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");
        System.out.println(ts);
    }
}
