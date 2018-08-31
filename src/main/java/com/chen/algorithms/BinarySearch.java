package com.chen.algorithms;

import java.util.Arrays;

public class BinarySearch {

	public static int indexOf(int[] arr, int key) {
		int low = 0;
		int hight = arr.length-1;
		while(low<=hight) {
			int mid = low + (hight-low)/2;
			if(key>arr[mid]) {
				low = mid + 1;
			} else if(key<arr[mid]) {
				hight = mid - 1;
			} else { 
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[8];
		for (int i = 0; i < arr.length-1; i++) {
			arr[i] = (int)(Math.random()*10);
		}
		arr[arr.length-1] = 5;
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(indexOf(arr, 5));
		System.out.println(indexOf(new int[] {0,2}, 2));
	}
}
