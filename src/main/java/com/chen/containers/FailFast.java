package com.chen.containers;

/**
 * 快速修改异常
 */
public class FailFast {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        Iterator<String> it = list.iterator();
//        list.add("hello");
//        it.next();
        String str = "123,526,529";
        System.out.println(str);
        String[] arr = str.split(",");
        System.out.println(arr.length);
        System.out.println(arr);
    }
}
