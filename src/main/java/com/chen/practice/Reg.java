package com.chen.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum Test{
	GOOD,MORNING,YOU,ARE,RIGHT
}

public class Reg {
	Test test;
	public Reg(Test test) {
		this.test = test;
	}
	@Override
	public String toString() {
		return "test is "+test;
	}

	public static void main(String[] args) {
		/*Pattern pa = Pattern.compile(".*[^(mp4) | ^(mp3)]+");
		Matcher ma = pa.matcher("sdfdsfwemp345");
		System.out.println(ma.matches());*/
		System.out.println(new Reg(Test.GOOD));
		System.out.println(new Reg(Test.MORNING));
		
	}
}
