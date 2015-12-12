package com.devarchi33.excer;

/**
 * Created by donghoon on 2015. 12. 12..
 */
public class MultiThreadComp01 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ChildThreadWorker01());
        Thread t2 = new Thread(new ChildThreadWorker02());

        t1.start();
        t2.start();

        System.out.println("main thread terminated.");
    }

    static class ChildThreadWorker01 implements Runnable {

        private int i = 0;

        @Override
        public void run() {

            while (i < 10) {
                System.out.println(this.getClass() + "[" + i + "] Working>>>>>>>");
                i++;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ChildThreadWorker02 implements Runnable {
        private int i = 0;

        @Override
        public void run() {
            while (i < 10) {
                System.out.println(this.getClass() + "[" + i + "]+<<<<<<<working");
                i++;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
