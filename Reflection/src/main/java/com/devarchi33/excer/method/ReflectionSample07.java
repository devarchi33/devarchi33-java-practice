package com.devarchi33.excer.method;

import com.devarchi33.excer.vo.WorkerValue;

import java.lang.reflect.Method;

/**
 * Created by donghoon on 2015. 12. 19..
 */
public class ReflectionSample07 {

    public static void main(String[] args) {
        WorkerValue wv1 = new WorkerValue("Dong-Hoon Lee", WorkerValue.POSITION_MANAGER);
        WorkerValue wv2 = new WorkerValue("Hyun-Kyu Lee", WorkerValue.POSITION_EMPLOYEE);

        Class clazz = WorkerValue.class;

        try {
            Method method = clazz.getMethod("getName", new Class[]{});

            Object rt1 = method.invoke(wv1, new Class[]{});
            Object rt2 = method.invoke(wv2, new Class[]{});

            System.out.println("rt1: " + rt1);
            System.out.println("rt2: " + rt2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
