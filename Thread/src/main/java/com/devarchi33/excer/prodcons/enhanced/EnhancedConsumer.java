package com.devarchi33.excer.prodcons.enhanced;

import com.devarchi33.excer.prodcons.ResourceQueue;

/**
 * Created by donghoon on 2015. 12. 17..
 */
public class EnhancedConsumer implements Runnable {

    private EnhancedResourceQueue queue;

    public EnhancedConsumer(EnhancedResourceQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Integer res = (Integer) queue.pop();
                if (res != null)
                    System.out.println(Thread.currentThread().getName() + ":pop: " + res);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

        }
    }
}
