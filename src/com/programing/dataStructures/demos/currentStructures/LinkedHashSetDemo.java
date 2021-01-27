/**
 * Thanks to https://www.tutorialspoint.com/java/java_linkedhashset_class.htm
 */
package com.programing.dataStructures.demos.currentStructures;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

    public static void main(String args[]) {
        // create a hash set
        LinkedHashSet lhs = new LinkedHashSet();

        // add elements to the hash set
        lhs.add("B");
        lhs.add("A");
        lhs.add("D");
        lhs.add("E");
        lhs.add("C");
        lhs.add("F");

        System.out.println(lhs);
    }
}
