package com.devarchi33.excer;

/**
 * Created by donghoon on 2015. 12. 13..
 */
public class ThreadInfo {

    public static void main(String[] args) {
        String thName = Thread.currentThread().getName();
        String thGroup = Thread.currentThread().getThreadGroup().getName();

        System.out.println("Current Thread Name: " + thName);
        System.out.println("Current Thread Group Name: " + thGroup);
    }
}
