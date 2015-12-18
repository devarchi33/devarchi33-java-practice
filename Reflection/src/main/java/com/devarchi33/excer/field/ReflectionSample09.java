package com.devarchi33.excer.field;

import com.devarchi33.excer.vo.WorkerValue;

import java.lang.reflect.Field;

/**
 * Created by donghoon on 2015. 12. 19..
 */
public class ReflectionSample09 {

    public static void main(String[] args) {
        WorkerValue wv = new WorkerValue("Dong-Hoon Lee", WorkerValue.POSITION_MANAGER);

        Class<WorkerValue> clazz = WorkerValue.class;

        try {
            Field f = clazz.getDeclaredField("position");

            //private 필드에 접근하기 위한 방법.
            f.setAccessible(true);
            Object val = f.get(wv);
            System.out.println("Field Modifier: " + ReflectionSample08.parseModifiers(f.getModifiers()) + ", Field Name: " + f.getName() + ", Field Value: " + val);

            f.set(wv, WorkerValue.POSITION_EMPLOYEE);
            val = f.get(wv);
            System.out.println("Field Modifier: " + ReflectionSample08.parseModifiers(f.getModifiers()) + ", Field Name: " + f.getName() + ", Field Value: " + val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
