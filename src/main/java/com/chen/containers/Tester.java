package com.chen.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**两个集合间的交集
 * @author chen
 */
public class Tester {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("java");
        list1.add("c++");
        list1.add("go");
        list1.add("java");
        List<String> list2 = new ArrayList<>();
        list2.add("java");
        list2.add("javaScript");

        System.out.println( Collections.disjoint(list1,list2));
     //   System.out.println(list1.retainAll(list2));
        System.out.println(list1);

        List<String> bs1 = new ArrayList<>();
       // bs1.add("aaa");
        bs1.add("bbb");
        bs1.add("ccc");
        bs1.add("ddd");
        bs1.add("aaa");


        System.out.println(list1.size());
        String key = list1.get(0);
        //使用二分法查找元素时，必须先排序
        Collections.sort(bs1);
        System.out.println(bs1);
        System.out.println(Collections.binarySearch(bs1,"aaa"));

    }
}
