package com.chen.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        System.out.printf("helloWorld!");
        Collection<String> collection = add(new String[]{"string1","string2","string3"});
        System.out.printf("collection:"+collection);
    }

    public static Collection add(String[] strings) {
        List<String> list = new ArrayList<>();
        for(String s:strings){
            list.add(s);
        }
        return list;
    }
}
