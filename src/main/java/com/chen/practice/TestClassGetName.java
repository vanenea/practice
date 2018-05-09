package com.chen.practice;

public class TestClassGetName {

	public TestClassGetName() {
		System.out.println("this is constructors!");
	}
	
	public TestClassGetName(int i) {
		System.out.println("contain int i!");
	}
	
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("com.chen.practice.TestClassGetName");
			Class cls2 = TestClassGetName.class;
			System.out.println(cls.getSimpleName());
			TestClassGetName.class.getClass();
			cls.newInstance();
			
			System.out.println(boolean.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		System.out.println("i:"+i);
	}
	
	
	
	static int i = 5;
	
	static {
		System.out.println("static block");
	}
	
	{
		System.out.println("blank");
	}
}
