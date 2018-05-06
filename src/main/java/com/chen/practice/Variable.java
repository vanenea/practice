package com.chen.practice;

public class Variable {

	private int count = 9;
	
	public static void main(String[] args) {
		Variable va1 = new Variable();
		va1.count++;
		
		Variable va2 = new Variable();
		va2.count--;
		System.out.println("count:"+va1.count);
		System.out.println("count:"+va2.count);
		
		
	}
}
