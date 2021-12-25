package com.chen.algorithms;

import java.util.Arrays;
import java.util.Random;

public class ShellDemo {
	 // sort the array a[] in ascending order using Shellsort
    public static void sort(int[] a) {
        int N = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
        int h = 1;
        while (h < N/3) h = 3*h + 1; 

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j]< a[j-h]; j -= h) {
                	int swap = a[j]; 
                	a[j] = a[j-h];
                	a[j-h] = swap;
                	System.out.println(Arrays.toString(a));
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
    	Random r = new Random();
		int[] arr = new int[] {8,9,1,7,2,3,5,4,6,0};
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = r.nextInt();
//		}
		System.out.println("orignal:"+Arrays.toString(arr));
		sort(arr);
		System.out.println("end:"+Arrays.toString(arr));
	}
}
