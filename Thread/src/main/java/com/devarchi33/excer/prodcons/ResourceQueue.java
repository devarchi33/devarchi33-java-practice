package com.devarchi33.excer.prodcons;

import java.util.LinkedList;

/**
 * Created by donghoon on 2015. 12. 17..
 */
public class ResourceQueue {

    private LinkedList<Object> jobs = new LinkedList<Object>();

    public synchronized void clear() {
        jobs.clear();
    }

    public synchronized Object pop() throws InterruptedException {
        Object obj = null;
        if (!jobs.isEmpty()) {
            obj = jobs.removeFirst();
        }

        return obj;
    }

    public synchronized void push(Object obj) {
        jobs.addLast(obj);
    }
}
