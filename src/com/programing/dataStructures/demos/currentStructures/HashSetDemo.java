/**
 * Thanks to https://www.tutorialspoint.com/java/java_hashset_class.htm
 */
package com.programing.dataStructures.demos.currentStructures;

import java.util.HashSet;

public class HashSetDemo {

    public static void main(String args[]) {
        // create a hash set
        HashSet hs = new HashSet();

        // add elements to the hash set
        hs.add("B");
        hs.add("A");
        hs.add("D");
        hs.add("E");
        hs.add("C");
        hs.add("F");

        System.out.println(hs);

        // clone
        Object o = hs.clone();
        System.out.println(o);
    }
}
