package com.devarchi33.excer.prodcons.enhanced;

import java.util.LinkedList;

/**
 * Created by donghoon on 2015. 12. 17..
 */
public class EnhancedResourceQueue {

    private LinkedList<Object> jobs = new LinkedList<Object>();

    public synchronized void clear() {
        jobs.clear();
    }

    public synchronized Object pop() throws InterruptedException {
        Object obj = null;

        if (jobs.isEmpty())
            this.wait();

        obj = jobs.removeFirst();

        return obj;
    }

    public synchronized void push(Object obj) {
        jobs.addLast(obj);
        this.notify();
    }
}
