/**
 * Thanks to https://www.tutorialspoint.com/java/java_stack_class.htm
 */
package com.programing.dataStructures.demos.oldStructures;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackDemo {

    static void showPush(Stack st, int a) {
        st.push(Integer.valueOf(a));
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }

    static void showPop(Stack st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    public static void main(String args[]) {
        Stack st = new Stack();
        System.out.println("stack: " + st);
        showPush(st, 42);
        showPush(st, 66);
        showPush(st, 99);
        showPop(st);
        showPop(st);
        showPop(st);
        try {
            showPop(st);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
    }
}
