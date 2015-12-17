package com.devarchi33.excer.prodcons;

/**
 * Created by donghoon on 2015. 12. 17..
 */
public class Consumer implements Runnable {

    private ResourceQueue queue;

    public Consumer(ResourceQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Integer res = (Integer) queue.pop();
                if (res != null) {
                    System.out.println(Thread.currentThread().getName() + ":pop: " + res);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
