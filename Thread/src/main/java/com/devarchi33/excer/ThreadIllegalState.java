package com.devarchi33.excer;

/**
 * Created by donghoon on 2015. 12. 13..
 */
public class ThreadIllegalState implements Runnable {

    public static void main(String[] args) {

        Thread th = new Thread(new ThreadIllegalState());
        th.start();
        th.start(); //start()의 중복  -->  ThreadIllegalStateException.
        System.out.println("MainThread teminated.");
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 30) {
            System.out.println("[" + i + "]: This Thread Working....");
            i++;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
