package com.chen.practice;

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
		
	}
	
	public static int add(int a) {
		return ++a;
	}
}
