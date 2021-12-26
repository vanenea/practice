package com.chen.practice;

public class Reflection {
	
	public static void main(String[] args) {
		String name = Reflection.class.getMethods()[0].getName();
		String value = Reflection.class.getMethods()[0].toString();
		Reflection.class.getDeclaredMethods();
		System.out.println(Reflection.class.getEnumConstants());
		System.out.println("value:"+value+",\tname:"+name+"\t"+Reflection.class.getDeclaredMethods());
		ProcessDemo.command("javap test");
	}
}
