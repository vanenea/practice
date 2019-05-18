package com.chen.practice;

import java.util.HashMap;
import java.util.Map;

public class DoSomething {

	public static void main(String[] args) {
		int a = 5 & 1;
		int c = 3 | 2;
		System.out.println(a);
		System.out.println(c);
		System.out.println(-5/3);
		int b = 3;
		add(b);
		System.out.println(b);
		System.out.println(System.getProperty("user.name"));
		String[] str = new String[1];
		System.out.println(str.getClass());
		System.out.println(System.getProperty("java.io.tmpdir"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "John");
		map.put("age", "18");
		for(String key : map.keySet()) {
			System.out.println(key);
			System.out.println(map.get(key));
		}
		
	}
	
	public static int add(int a) {
		return ++a;
	}
}
