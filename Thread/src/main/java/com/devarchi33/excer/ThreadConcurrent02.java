package com.devarchi33.excer;

/**
 * Created by donghoon on 2015. 12. 15..
 */
public class ThreadConcurrent02 implements Runnable {

    private static int val = 0;

    public static void main(String[] args) {
        ThreadConcurrent02 concurrent01 = new ThreadConcurrent02();
        Thread th1 = new Thread(concurrent01);
        Thread th2 = new Thread(concurrent01);

        th1.start();
        th2.start();

        try {
            th1.join(); //스레드가 종료될 때까지 기다리게 하는 메소드.
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Value: " + concurrent01.val);
    }

    @Override
    public void run() {
        sum();
    }

    private synchronized void sum() {
        for (int i = 0; i < 10000; i++) {
            val++;
        }
    }
}
