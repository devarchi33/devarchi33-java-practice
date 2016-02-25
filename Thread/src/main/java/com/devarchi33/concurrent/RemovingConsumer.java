package com.devarchi33.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by donghoon on 2016. 2. 25..
 */
public class RemovingConsumer implements Runnable {

    private LinkedBlockingQueue queue;
    private Producer producer;

    public RemovingConsumer(LinkedBlockingQueue queue, Producer producer) {
        this.queue = queue;
        this.producer = producer;
    }

    @Override
    public void run() {
        while (producer.isRunning()) {
            try {
                System.out.println("Remove element: " + queue.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Complete removing elements.");
    }
}
