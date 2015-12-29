package com.devarchi33.java7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by donghoon on 2015. 12. 29..
 */
public class ThreadSyncList {

    public static void main(String[] args) {
        ThreadSyncList tl = new ThreadSyncList();
        tl.start();
    }

    private void start() {
        System.out.println("Using CopyOnWrite");
        copyOnWriteSolution();
        System.out.println("Using SynchronizedList");
        synchronizedSolution();
    }

    private void synchronizedSolution() {
        final List<String> list = Collections.synchronizedList(new ArrayList<>());
        startUpdatingThread(list);
        synchronized (list) {
            for (String element : list) {
                System.out.println("Element: " + element);
            }
        }
        stopUpdatingThread();
    }

    private void copyOnWriteSolution() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        startUpdatingThread(list);
        for (String element :
                list) {
            System.out.println("Element: " + element);
        }
        stopUpdatingThread();
    }

    private void stopUpdatingThread() {
        updateThread.interrupt();
    }

    Random random = new Random();

    Thread updateThread;

    private void startUpdatingThread(final List<String> list) {
        updateThread = new Thread(new Runnable() {
            long counter = 0;

            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    int size = list.size();
                    if (random.nextBoolean()) {
                        if (size > 1) {
                            list.remove(random.nextInt(size - 1));
                        }
                    } else {
                        if (size < 20) {
                            list.add("Random string " + counter);
                        }
                    }
                    counter++;
                }
            }
        });

        updateThread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
