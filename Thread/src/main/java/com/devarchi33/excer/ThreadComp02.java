package com.devarchi33.excer;

/**
 * Created by donghoon on 2015. 12. 12..
 */
public class ThreadComp02 implements Runnable {

    @Override
    public void run() {
        System.out.println("Implements Runnable Comprehension.");
    }

    public static void main(String[] args) {
        Runnable r = new ThreadComp02();
        Thread t = new Thread(r);
        t.start();
    }
}
