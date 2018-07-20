package com.chen.containers;

import com.chen.domain.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 快速修改异常
 */
public class FailFast {

    static List<User> user1 = new ArrayList<>();
    static List<User> user2 = new ArrayList<>();

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        Iterator<String> it = list.iterator();
//        list.add("hello");
//        it.next();
//        String str = "123,526,529";
//        System.out.println(str);
//        String[] arr = str.split(",");
//        System.out.println(arr.length);
//        System.out.println(arr);

        user1.add(new User(1,"chen","123456"));
//        Iterator<User> it = user1.iterator();
//        while (it.hasNext()){
//            user2.add(it.next().clone());
//        }
 //       user2.clear();
        user2.addAll(user1);
//        user2.add(user1.get(0));

        System.out.println("user1:"+user1);
        System.out.println("user2:"+user2);

    //    Collections.copy(user2,user1);
        user2.get(0).setId(8);

        System.out.println("user1:"+user1);
        System.out.println("user2:"+user2);

        System.out.println("#############");
        
        
    }
}
