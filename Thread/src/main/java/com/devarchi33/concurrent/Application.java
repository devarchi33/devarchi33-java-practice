package com.devarchi33.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by donghoon on 2016. 2. 25..
 */
public class Application {

    public static void main(String... args) {
        LinkedBlockingQueue queue = new LinkedBlockingQueue(10);

        Producer producer = new Producer(queue);
        ObservingConsumer observingConsumer = new ObservingConsumer(queue, producer);
        RemovingConsumer removingConsumer = new RemovingConsumer(queue, producer);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(observingConsumer);
        Thread thread3 = new Thread(removingConsumer);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
