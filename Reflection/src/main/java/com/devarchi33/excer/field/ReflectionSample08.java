package com.devarchi33.excer.field;

import com.devarchi33.excer.vo.WorkerValue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by donghoon on 2015. 12. 19..
 */
public class ReflectionSample08 {

    public static void main(String[] args) {
        WorkerValue wv = new WorkerValue("Dong-Hoon Lee", WorkerValue.POSITION_MANAGER);

        Class clazz = WorkerValue.class;

        Field[] fields = clazz.getFields();

        for (int i = 0; fields != null && i < fields.length; i++) {
            Field f = fields[i];

            try {
                Object obj = f.get(wv);
                System.out.println("Field Modifier: " + ReflectionSample08.parseModifiers(f.getModifiers()) + ", Field Name: " + f.getName() + ", Field Value: " + obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String parseModifiers(int modifiers) {
        StringBuffer sb = new StringBuffer();

        if (Modifier.isAbstract(modifiers))
            sb.append("abstract");

        if (Modifier.isFinal(modifiers))
            sb.append("final");

        if (Modifier.isPrivate(modifiers))
            sb.append("private");

        if (Modifier.isProtected(modifiers))
            sb.append("protected");

        if (Modifier.isPublic(modifiers))
            sb.append("public");

        if (Modifier.isStatic(modifiers))
            sb.append("static");

        if (Modifier.isSynchronized(modifiers))
            sb.append("synchronized");

        return sb.toString();
    }
}
