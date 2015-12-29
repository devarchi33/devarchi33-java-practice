package com.devarchi33.java7;

/**
 * Created by donghoon on 2015. 12. 29..
 */
public class ThreadBackground {

    public static void main(String[] args) {
        ThreadBackground tb = new ThreadBackground();
        tb.someMethod();
    }

    public void someMethod() {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                doSomethingBackground();
            }
        }, "Background Thread");

        System.out.println("Start");

        /**
         * daemon thread로 설정하면 main thread가 종료되면 background 작업이 수행 되지 않더라도 같이 종료됨.
         */
        backgroundThread.setDaemon(true);
        backgroundThread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is counting " + i);
        }
        System.out.println("Done");
    }

    public void doSomethingBackground() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " is background running");
    }
}
