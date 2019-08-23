package com.chen.practice;

public class SplitTest {

	public static void main(String[] args) {
		String str = "123##77777##";
		System.out.println(str.replace("##", "&"));
		System.out.println(str.replaceAll("##", "&"));
	}
}
