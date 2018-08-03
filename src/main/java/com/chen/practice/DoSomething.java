package com.chen.practice;

import java.util.regex.Pattern;

public class DoSomething {

	public enum Company{
		BOSS{void action(){System.out.println("this is boss");}};
		abstract void action();
	}
	
	public static void main(String[] args) {
		Company[] company = Company.values();
		for (Company company2 : company) {
			company2.action();
		}
		Pattern pa = Pattern.compile("\\d+");
		System.out.println(pa.matcher("52").matches());
		System.out.println(Float.isNaN(Integer.parseInt("123")));
		
		
		
		
		String str = null;
		try {
			str.split(",");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
}
