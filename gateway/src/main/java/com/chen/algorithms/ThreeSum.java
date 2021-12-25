package com.chen.algorithms;

import java.io.FileNotFoundException;

/**
 * 三个数相加为零
 * @author Administrator
 *
 */
public class ThreeSum {

	public static int count(int[] arry) {
		int count = 0;
		for (int i = 0; i < arry.length; i++) {
			for (int j = i+1; j < arry.length; j++) {
				for (int k = j+1; k < arry.length; k++) {
					if(arry[i]+arry[j]+arry[k]==0) {
						System.out.println(arry[i]+", "+arry[j]+", "+arry[k]);
						count ++;
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		try {
			In in = new In("8Kints.txt");
			Long last = System.currentTimeMillis();
			int  count = count(in.readInt());
			System.out.println((System.currentTimeMillis()-last)/1000.00);
			System.out.println(count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
}
