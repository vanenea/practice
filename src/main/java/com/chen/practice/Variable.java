package com.chen.practice;

public class Variable {
	
	public static void main(String[] args) {
		
		System.out.println("111111");
		try {
			test();
		} catch (Exception e) {
			System.out.println("22222");
			throw new RuntimeException("出错了");
		}
		System.out.println("333333");
	}
	
	public static void test() {
		throw new RuntimeException("出错了");
	}
}
