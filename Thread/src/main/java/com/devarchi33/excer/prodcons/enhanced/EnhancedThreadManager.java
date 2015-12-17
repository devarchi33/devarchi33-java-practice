package com.devarchi33.excer.prodcons.enhanced;

/**
 * Created by donghoon on 2015. 12. 17..
 */
public class EnhancedThreadManager {

    public static void main(String[] args) {
        EnhancedResourceQueue queue = new EnhancedResourceQueue();
        Thread th1 = new Thread(new EnhancedProducer(queue), "Producer");
        Thread th2 = new Thread(new EnhancedConsumer(queue), "Consumer1");
        Thread th3 = new Thread(new EnhancedConsumer(queue), "Consumer2");

        th1.start();
        th2.start();
        th3.start();
    }
}
