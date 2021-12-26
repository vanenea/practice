package com.chen.practice;

import java.util.Arrays;
import java.util.Random;

public class Temporary implements Comparable<Temporary>  {

	private Integer id;
	

	/**
	 * 选择排序
	 * @param arr
	 * @return
	 */
	public static int[] selection(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]) {
					int swap = arr[i];
					arr[i] = arr[j];
					arr[j] = swap;
				}
			}
		}
		return arr;
	}
	
	/**
	 * 插入排序
	 * @param arr
	 * @return
	 */
	public static int[] insertion(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i;j>0 && arr[j-1]>arr[j]; j--) { //插入到合适的位置
				int swap = arr[i];
				arr[i] = arr[j];
				arr[j] = swap;
			}
		}
		return arr;
	}
	
	@Override
	public int compareTo(Temporary that) {
		return this.id-that.id;
	}
	
	public static void main(String[] args) {
		Random r = new Random();
		int[] arr = new int[200000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt();
		}
		long last = System.currentTimeMillis();
		Arrays.toString(selection(arr));
		long current = System.currentTimeMillis();
		System.out.println(current-last);
		last = System.currentTimeMillis();
		Arrays.toString(insertion(arr));
		System.out.println(System.currentTimeMillis()-last);
	}
}
