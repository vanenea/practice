package com.chen.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapSpaceOOM {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        String s = "hello";
        int i = 0;
        try {
            while (true) {
                list.add(s);
                i++;
                s = s + s;
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(i);
        }

    }
}
