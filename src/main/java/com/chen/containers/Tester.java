package com.chen.containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Tester {

    public static void main(String[] args) {
        Collection<String> list1 = new ArrayList<>();
        list1.add("java");
        list1.add("c++");
        list1.add("go");

        List<String> list2 = new ArrayList<>();
        list2.add("java");
        list2.add("javaScript");

        System.out.println( Collections.disjoint(list1,list2));
        System.out.println(list1.retainAll(list2));
        System.out.println(list1);

    }
}
