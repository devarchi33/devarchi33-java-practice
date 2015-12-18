package com.devarchi33.excer;

import java.lang.reflect.Constructor;

/**
 * Created by donghoon on 2015. 12. 18..
 */
public class ReflectionSample05 {

    public static void main(String[] args) {
        Class<?> clazz = String.class;

        try {
            //기본 생성자를 의미하는 Constructor 객체 받는 방법.
            Constructor<?> c1 = clazz.getConstructor();

            System.out.println(c1.toString());
        } catch (Exception e) {

        }
    }
}
