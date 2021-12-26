package com.chen.getData1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Demo1 {
	/** 生成每期的时间 */
	public static void main(String[] args) {
		String time = "08:39:00";
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		for (int i = 1; i <= 80; i++) {
			Calendar cal = Calendar.getInstance();
			try {
				cal.setTime(sdf.parse(time));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			cal.add(Calendar.MINUTE, +10);
			time = sdf.format(cal.getTime());
			System.err.println(sdf.format(cal.getTime()));
		}
		//System.err.println("09:07:00-"+179);
	}

}
