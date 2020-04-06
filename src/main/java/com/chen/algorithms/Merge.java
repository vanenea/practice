package com.chen.algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * 利用归并排序
 *
 * @author Administrator
 */
public class Merge {

    public static void main(String[] args) {
        Random r = new Random();
        int[] arr1 = new int[6];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = r.nextInt(50);
        }
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = new int[5];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = r.nextInt(50);
        }
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        int[] arr = new int[arr1.length + arr2.length];
        //造数据
        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);

        System.out.println("before:" + Arrays.toString(arr));
        merge(arr, 0, arr.length - 1);
        System.out.println("after:" + Arrays.toString(arr));
        int[] la = new int[]{1,3,4,8};
        int[] lb = new int[]{2,4,7,9};
        System.out.println("====== lc ======");
        int[] lc = merge(la, lb);
        for (int i = 0; i < lc.length; i++) {
            System.out.println(lc[i]);
        }

    }

    public static int[] merge(int[] la, int[] lb) {
        int[] lc = new int[la.length+lb.length];
        int i = 1, j = 1, k = 1;
        while (i < la.length && j < lb.length) {
            if (la[i] < lb[j]) {
                lc[k++] = la[i++];
            } else {
                lc[k++] = lb[j++];
            }
            while (i < la.length) {
                lc[k++] = la[i++];
            }
            while (j < lb.length) {
                lc[k++] = lb[j++];
            }
        }

        return lc;
    }

    public static void merge(int[] arr, int lo, int hi) {
        int i = lo;
        int mid = (hi - lo) / 2 + lo;
        int m = (hi - lo) / 2 + lo + 1;
        int[] temp = new int[arr.length];
        for (int k = lo; k <= hi; k++) {
            temp[k] = arr[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = temp[m++];
            } else if (m > hi) {
                arr[k] = temp[i++];
            } else if (temp[m] < temp[i]) {
                arr[k] = temp[m++];
            } else {
                arr[k] = temp[i++];
            }
        }
    }




}
