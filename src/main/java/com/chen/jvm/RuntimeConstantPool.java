package com.chen.jvm;

public class RuntimeConstantPool {

    public static void main(String[] args) {

        String str1 = new StringBuilder("中国").append("钓鱼岛").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString(); //虚拟机方法区中的常量池里面估计设计的时候就是有java
        System.out.println(str2.intern() == str2);

        String str3 = new StringBuilder("ja").append("va1").toString(); //虚拟机方法区中的常量池里面估计设计的时候就是有java
        System.out.println(str3.intern() == str3);

    }
}
