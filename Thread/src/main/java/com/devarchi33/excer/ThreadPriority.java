package com.devarchi33.excer;

/**
 * Created by donghoon on 2015. 12. 13..
 */
public class ThreadPriority implements Runnable {

    public static void main(String[] args) {
        Thread th = new Thread(new ThreadPriority());
        th.setPriority(3);
        th.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        th.setPriority(10);
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 15) {
            System.out.println("Priority[" + i + "]: " + Thread.currentThread().getPriority());
            i++;
            try {
                Thread.sleep(100); //thread 정확한 제어를 위해서 sleep() 사용하기.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
