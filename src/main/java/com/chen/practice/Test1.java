package com.chen.practice;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {

    }

    public static Collection add(String[] strings) {
        List<String> list = new ArrayList<>();
        for(String s:strings){
            list.add(s);
        }
        return list;
    }
}
