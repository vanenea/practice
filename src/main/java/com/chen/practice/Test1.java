package com.chen.practice;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        System.out.println("helloWorld!");
        Collection<String> collection = add(new String[]{"string1","string2","string3"});
        System.out.println("collection:"+collection);
        int i=0;
        List<String> list = new ArrayList<>();
        list.add("str");
        while(true) {
            list.addAll(list);
            System.out.println("list:"+list);
        }
    }

    public static Collection add(String[] strings) {
        List<String> list = new ArrayList<>();
        for(String s:strings){
            list.add(s);
        }
        return list;
    }
}
