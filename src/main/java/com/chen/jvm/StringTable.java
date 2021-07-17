package com.chen.jvm;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;

public class StringTable {

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "a" + "b";
        String s4 = s1 + s2;
        String s5 = "ab";
        String s6 = s4.intern();

        //问
        System.out.println(s3 == s4);   // false
        System.out.println(s3 == s5);   //true
        System.out.println(s3 == s6);   //true


        String x2 = new String("c") + new String("d");

        String x3 = x2.intern();
        System.out.println(x2 == "cd"); //true    1.6   false
        System.out.println(x3 == "cd"); //true    1.6   true

        String x11 = "cd";
        String x22 = new String("c") + new String("d");

        String x33 = x22.intern();
        System.out.println(x33 == x11);  //true
        System.out.println(x22 == x11);     //false

        //问：如果调换了【最后两行代码】的位置呢 ，如果是jdk1.6呢

    }
}

