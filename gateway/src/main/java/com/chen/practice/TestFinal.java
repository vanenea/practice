package com.chen.practice;

import java.util.Deque;
import java.util.Hashtable;
import java.util.Vector;

class BasicClass{
	public final void say() {
		System.out.println("basic");
	}
		
	
}
public class TestFinal extends BasicClass{

	// compile fail
//	public final void say() {
//		System.out.println("be");
//	}
	public static void main(String[] args) {
		TestFinal tes = new TestFinal();
		tes.say();
		Deque<String> de;
		Vector ver;
		Hashtable ht;
		byte a = 'a';
		System.out.println((float)a);
		System.out.println((int)1.36e-43f);
	}
}
