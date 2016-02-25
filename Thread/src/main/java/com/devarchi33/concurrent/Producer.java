package com.devarchi33.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by donghoon on 2016. 2. 25..
 */
public class Producer implements Runnable {

    private LinkedBlockingQueue queue;
    private boolean running = true;

    public Producer(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            String element = "String:" + i;
            try {
                queue.put(element);
                System.out.println("Adding Element: " + element);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Complete producing element.");
        running = false;
    }
}
