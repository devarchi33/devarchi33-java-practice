package com.devarchi33.excer;

import javassist.*;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * Created by donghoon on 2015. 12. 21..
 */
public class MyBciAgent implements ClassFileTransformer {
    public MyBciAgent() {
        super();
    }

    public static void premain(String agentArguments,
                               Instrumentation instrumentation) {
        instrumentation.addTransformer(new MyBciAgent());
    }

    @Override
    public byte[] transform(ClassLoader loader, String className,
                            Class redefiningClass, ProtectionDomain domain, byte[] bytes)
            throws IllegalClassFormatException {
        String[] ignore = new String[]{"sun/", "java/", "javax/"};
        for (int i = 0; i < ignore.length; i++) {
            if (className.startsWith(ignore[i])) {
                return bytes;
            }
        }
        return transformClass(redefiningClass, bytes);
    }

    private byte[] transformClass(Class classToTransform, byte[] b) {
        ClassPool pool = ClassPool.getDefault();
        CtClass cl = null;
        try {
            cl = pool.makeClass(new ByteArrayInputStream(b));
            if (cl.isInterface() == false) {
                CtBehavior[] methods = cl.getDeclaredBehaviors();
                for (int i = 0; i < methods.length; i++) {
                    if (methods[i].isEmpty() == false) {
                        doTransform(methods[i]);
                    }
                }
            }
            b = cl.toBytecode();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cl != null) {
                cl.detach();
            }
        }
        return b;
    }

    private void doTransform(CtBehavior method) throws NotFoundException,
            CannotCompileException {
        if (method.getName().equals("doSomething")) {
            method.insertBefore("System.out.println(\"started method at \" + new java.util.Date());");
            method.insertAfter("System.out.println(\"ended method at \" + new java.util.Date());");
        }
    }
}
