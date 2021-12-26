package com.chen.practice;

import java.util.Random;
import java.util.UUID;

public class Chinese {
	
	public static void main(String[] args) {
		String str = "中国.png";
		System.out.println(str.replaceAll("[\u4e00-\u9fa5]", "..."));
		System.out.println(UUID.randomUUID());
		Random r = new Random();
		System.out.println(""+(char)(r.nextInt(26)+'a')+r.nextInt(10000));
		System.out.println("++++ "+str.substring(0, str.lastIndexOf(".")+1));
	}
}
