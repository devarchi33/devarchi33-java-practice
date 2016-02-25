package com.devarchi33.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by donghoon on 2016. 2. 25..
 */
public class ObservingConsumer implements Runnable {

    private LinkedBlockingQueue queue;
    private Producer producer;

    public ObservingConsumer(LinkedBlockingQueue queue, Producer producer) {
        this.queue = queue;
        this.producer = producer;
    }

    @Override
    public void run() {
        while (producer.isRunning()) {
            System.out.println("Get Elements: " + queue);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Complete observing queue element");
        System.out.println("Final elements: " + queue);
    }
}
