package com.devarchi33.excer.prodcons;

/**
 * Created by donghoon on 2015. 12. 17..
 */
public class ThreadManager {

    public static void main(String[] args) {
        ResourceQueue queue = new ResourceQueue();
        Thread th1 = new Thread(new Producer(queue), "Producer");
        Thread th2 = new Thread(new Consumer(queue), "Consumer1");
        Thread th3 = new Thread(new Consumer(queue), "Consumer2");

        th1.start();
        th2.start();
        th3.start();
    }
}
