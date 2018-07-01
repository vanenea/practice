package com.chen.containers;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {

    public static void main(String[] args) {
        LinkedHashMap<String,String> map = new LinkedHashMap<String, String>(16,0.75f,true);
        map.put("0","Zero");
        map.put("1","One");
        map.put("2","Two");
        map.put("3","Three");
        System.out.println(map);
        for (int i = 0; i < 2; i++) {
            map.get(i);
            System.out.println(map.get(Integer.valueOf(i).toString()));
        }
        System.out.println(map);
    }
}
