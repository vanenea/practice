package com.chen.jvm;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * java.lang.OutOfMemoryError: Metaspace
 * -XX:MaxMetaspaceSize=8m jdk1.8及以后
 * -XX:MaxPermSize=25m      jdk1.8之前
 */
public class MethodAreaOOM extends ClassLoader {
    public static void main(String[] args) {
        MethodAreaOOM h = new MethodAreaOOM();
        int a = 0;
        try {
            for (int i = 0; i < 100000; i++) {

                ClassWriter cw = new ClassWriter(0);
                cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                byte[] bytes = cw.toByteArray();
                h.defineClass("Class" + i, bytes, 0, bytes.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(a);
        }

    }
}
