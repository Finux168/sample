package com.xiaorboo.sort;

import java.util.Arrays;

/**
 * O(n2)  n的平方  时间复杂度的排序算法
 *
 * 冒泡
 *
 * @Author: fgd
 * @Date: 2019-10-31
 */
public class On2TimeSort {

    public static void main(String[] args) {
        //定义数组
        int[] arr = new int[]{1,4,7,3,2,8,66,43,2,34,88,99,23};
        //排序
//        bubbleSort(arr);
        arr = insertSort(arr);

        //打印
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int[] insertSort(int[] arr){
        int[] nArr = new int[arr.length];
        nArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int j = i-1;
            while (j >= 0 && arr[i]< nArr[j]){
                nArr[j+1] = nArr[j];
                j--;
            }
            nArr[j+1] = arr[i];
        }
        return nArr;
    }
}
