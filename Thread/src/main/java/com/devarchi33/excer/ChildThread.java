package com.devarchi33.excer;

/**
 * Created by donghoon on 2015. 12. 12..
 */
public class ChildThread implements Runnable {

    private int i = 0;

    public static void main(String[] args) {
        Thread th = new Thread(new ChildThread());
        th.start();
        System.out.println("Main Thread Terminated.");
    }

    @Override
    public void run() {
        while (i < 10) {
            System.out.println("[" + i + "] thread: " + "is running....");
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
