package com.chen.practice;

public class EnvironmentV {

	public static void main(String[] args) {
		System.out.println(System.getenv());
		int b = 0;
		while(true) {
			int[] a = new int[100000];
			String s = "str"+b;
			b++;
			System.out.println("b:"+s);
		}
	}
}
