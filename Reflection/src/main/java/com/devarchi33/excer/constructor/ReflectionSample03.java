package com.devarchi33.excer.constructor;

import com.devarchi33.excer.vo.WorkerValue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by donghoon on 2015. 12. 18..
 */
public class ReflectionSample03 {

    public static void main(String[] args) {
        Class clazz = WorkerValue.class;

        //선언된 class 생성자 정보.
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        System.out.println("-Declared Constructors------------------------------");
        for (int i = 0; declaredConstructors != null && i < declaredConstructors.length; i++) {
            System.out.println(declaredConstructors[i].toString());
        }
        System.out.println();

        //선언된 class 메소드 정보.
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println("-Declared Methods-----------------------------------");
        for (int i = 0; declaredMethods != null && i < declaredMethods.length; i++) {
            System.out.println(declaredMethods[i].toString());
        }
        System.out.println();

        //선언된 class 필드 정보.
        Field[] declaredFields = clazz.getDeclaredFields();
        System.out.println("-Declared Field-------------------------------------");
        for (int i = 0; declaredFields != null && i < declaredFields.length; i++) {
            System.out.println(declaredFields[i].toString());
        }
        System.out.println();

        //class 생성자 정보.
        Constructor[] constructors = clazz.getConstructors();
        System.out.println("-Constructors------------------------------");
        for (int i = 0; constructors != null && i < constructors.length; i++) {
            System.out.println(constructors[i].toString());
        }
        System.out.println();

        //class 메소드 정보.
        Method[] methods = clazz.getMethods();
        System.out.println("-Methods-----------------------------------");
        for (int i = 0; methods != null && i < methods.length; i++) {
            System.out.println(methods[i].toString());
        }
        System.out.println();

        //class 필드 정보.
        Field[] fields = clazz.getFields();
        System.out.println("-Field-------------------------------------");
        for (int i = 0; fields != null && i < fields.length; i++) {
            System.out.println(fields[i].toString());
        }
        System.out.println();
    }
}
