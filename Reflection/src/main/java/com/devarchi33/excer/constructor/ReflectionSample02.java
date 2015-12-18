package com.devarchi33.excer.constructor;

import com.devarchi33.excer.vo.WorkerValue;

/**
 * Created by donghoon on 2015. 12. 18..
 */
public class ReflectionSample02 {

    public static void main(String[] args) {
        WorkerValue wv = new WorkerValue("DHL", WorkerValue.POSITION_MANAGER);

        Class clazz1 = WorkerValue.class;
        Class clazz2 = wv.getClass();
        Class clazz3 = null;

        try {
            clazz3 = Class.forName("com.devarchi33.excer.vo.WorkerValue");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Hash code clazz1: " + System.identityHashCode(clazz1));
        System.out.println("Hash code clazz2: " + System.identityHashCode(clazz2));
        System.out.println("Hash code clazz3: " + System.identityHashCode(clazz3));
        System.out.println("Hash code null: " + System.identityHashCode(null));
    }
}
