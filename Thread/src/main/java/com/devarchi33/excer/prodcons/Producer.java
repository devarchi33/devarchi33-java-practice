package com.devarchi33.excer.prodcons;

/**
 * Created by donghoon on 2015. 12. 17..
 */
public class Producer implements Runnable {

    private ResourceQueue queue;

    public Producer(ResourceQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            queue.push(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
