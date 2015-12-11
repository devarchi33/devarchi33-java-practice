package com.devarchi33.excer;

/**
 * Created by donghoon on 2015. 12. 12..
 */
public class ThreadComp01 extends Thread {
    public void run() {
        System.out.println("Extends Thread Comprehension.");
    }

    public static void main(String[] args) {
        ThreadComp01 tc = new ThreadComp01();
        tc.run();
    }
}
