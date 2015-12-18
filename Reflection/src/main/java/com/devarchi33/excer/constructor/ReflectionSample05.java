package com.devarchi33.excer.constructor;

import java.lang.reflect.Constructor;

/**
 * Created by donghoon on 2015. 12. 18..
 */
public class ReflectionSample05 {

    public static void main(String[] args) {
        Class<?> clazz = String.class;

        try {
            //기본 생성자를 의미하는 Constructor 객체 생성 방법.
            Constructor<?> c1 = clazz.getConstructor();

            //매개변수 1개를 받는 Constructor 객체 생성 방법.
            Constructor<?> c2 = clazz.getConstructor(String.class);
            Constructor<?> c3 = clazz.getConstructor(StringBuilder.class);
            Constructor<?> c4 = clazz.getConstructor(byte[].class);

            //매개변수 2개를 받는 Constructor 객체 생성 방법
            Constructor<?> c5 = clazz.getConstructor(byte[].class, Integer.TYPE);

            Class<?>[] paramClasses = new Class[]
                    {byte[].class, Integer.TYPE, Integer.TYPE};
            Constructor<?> c6 = clazz.getConstructor(paramClasses);

            System.out.println("Constructor1: " + c1.toString());
            System.out.println("Constructor2: " + c2.toString());
            System.out.println("Constructor3: " + c3.toString());
            System.out.println("Constructor4: " + c4.toString());
            System.out.println("Constructor5: " + c5.toString());
            System.out.println("Constructor6: " + c6.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
