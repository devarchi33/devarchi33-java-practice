package com.devarchi33.excer.prodcons.enhanced;

import com.devarchi33.excer.prodcons.ResourceQueue;

/**
 * Created by donghoon on 2015. 12. 17..
 */
public class EnhancedProducer implements Runnable {

    private EnhancedResourceQueue queue;

    public EnhancedProducer(EnhancedResourceQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 && !Thread.interrupted(); i++) {
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
