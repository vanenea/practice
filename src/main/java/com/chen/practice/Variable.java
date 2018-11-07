package com.chen.practice;

import java.util.Calendar;
import java.util.Date;

public class Variable {

	private int count = 9;

	public static final double i = Math.random();
	
	public static void main(String[] args) {
//		Variable va1 = new Variable();
//		va1.count++;
//		
//		Variable va2 = new Variable();
//		va2.count--;
//		System.out.println("count:"+va1.count);
//		System.out.println("count:"+va2.count);
		System.out.println(i);
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date d = new Date();
		long time = calendar.getTimeInMillis()-d.getTime();
		System.out.println(time);
		double hours =  time/(1000.00*60*60);
		System.out.println(hours);
	}
	
	class demo{
		public void prin() {
			System.out.println(count);
		}
	}
}
