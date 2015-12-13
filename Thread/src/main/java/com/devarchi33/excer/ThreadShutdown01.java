package com.devarchi33.excer;

/**
 * Created by donghoon on 2015. 12. 13..
 */
public class ThreadShutdown01 implements Runnable {

    private Boolean isAlive = true;

    public static void main(String[] args) {
        Thread th = new Thread(new ThreadShutdown01(), "Test");
        th.start();

        System.out.println("Press Ctrl + c to Exit");
    }

    public void shutdown() {
        System.out.println("[" + Thread.currentThread().getName() + "] called shutdown.");
        isAlive = false;
    }

    @Override
    public void run() {
        String thName = Thread.currentThread().getName();
        Thread shutDownHook = new ShutDownHook(Thread.currentThread(), "Force ShutDownHook");
        Runtime.getRuntime().addShutdownHook(shutDownHook); //강제 종료시 실행할 스레드 추가.

        while (isAlive) {
            System.out.println(thName + " is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("End of procedure.");
        }

        System.out.println(thName + " is terminated");
    }

    private class ShutDownHook extends Thread {
        private Thread target;

        public ShutDownHook(Thread target, String name) {
            super(name);
            this.target = target;
        }

        public void run() {
            shutdown();
            try {
                target.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
