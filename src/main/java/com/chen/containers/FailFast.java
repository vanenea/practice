package com.chen.containers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 快速修改异常
 */
public class FailFast {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Iterator<String> it = list.iterator();
        list.add("hello");
        it.next();
    }
}
