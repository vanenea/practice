package com.chen.algorithms;

public class MergeBU {

	public static void merge(int[] arr, int lo, int hi) {
		int i = lo;
		int mid = (hi-lo)/2 + lo;
		int m = (hi-lo)/2 + lo + 1;
		int[] temp = new int[arr.length];
		for (int k = lo; k <= hi; k++) {
			temp[k] = arr[k];
		}
		for (int k = lo; k <= hi; k++) {
			if(i > mid) {
				arr[k] = temp[m++];
			} else if(m > hi) {
				arr[k] = temp[i++];
			}else if(temp[m] < temp[i]) {
				arr[k] = temp[m++];
			}else {
				arr[k] = temp[i++];
			}
		}
	}
	
	/**
	 * 自底向上排序
	 * @param arr
	 * @param lo
	 * @param hi
	 */
	public static void sort(int[] arr, int lo, int hi) {
		int N = arr.length;
		for (int i = 1; i < N; i += i) {
			for(int j = 0; j < N-i; j +=i) {
			}
		}
	}
}
