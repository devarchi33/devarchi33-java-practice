package com.devarchi33.excer;

import com.devarchi33.excer.vo.WorkerValue;

import java.lang.reflect.Constructor;

/**
 * Created by donghoon on 2015. 12. 18..
 */
public class ReflectionSample06 {

    public static void main(String[] args) {
        ReflectionSample06 rs = new ReflectionSample06();
        rs.dynamicInstantiation();
    }

    public void dynamicInstantiation() {
        Class<WorkerValue> clazz = WorkerValue.class;

        try {
            Constructor<WorkerValue> paramCons = clazz.getConstructor(String.class, Integer.TYPE);

            //param 배열.
            Object[] params = new Object[]{new String("Donghoon Lee"), WorkerValue.POSITION_MANAGER};

            //동적 객체 생성.
            WorkerValue wv = paramCons.newInstance(params);

            System.out.println(wv.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
