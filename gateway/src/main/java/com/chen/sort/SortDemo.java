package com.chen.sort;

public class SortDemo {


    /**
     * 直接插入排序
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int inserNum = array[i];
            int j = i-1;
            while (j>=0 && array[j]>inserNum){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = inserNum;
        }
        return array;
    }

    /**
     * 简单选择排序
     * @param array
     * @return
     */
    public static int[] selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {

        }

        return null;
    }

    public static int[] bubble(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        /*int[] array = {5,5,9,8,2,1,25,12};
        int[] temp = insertSort(array);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(i==(temp.length-1)?temp[i]:(temp[i]+", "));
        }*/

        int[] array = {5,5,9,8,2,1,25,12};
        int[] temp = bubble(array);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(i==(temp.length-1)?temp[i]:(temp[i]+", "));
        }

    }
}
