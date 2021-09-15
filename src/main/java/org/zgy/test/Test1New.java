package org.zgy.test;

import java.util.Arrays;

/**
 * 已知一个有序大数组,查找一个值在这个有序数组中第一次出现的位置:
 * 如[1, 2, 3, 3, 4, 4, 4, 5, ..., n] 中4 第一次出现的位置是  4
 *
 * public int index(int[] a, int key) {
 * }
 *
 * @author kennedyhan
 */
public class Test1New {

    public static int process(int[] a, int start, int end, int key) {
        if(start > end) {
//            if(a[end] == key) {
//                return end;
//            } else {
                return -1;
//            }
        }

//        int middle = (start + end) / 2 ;
        int middle =  start + ((end - start) >> 1);
        if( key > a[middle] ) {
            return process(a, middle + 1, end, key);
        } else if (key < a[middle]) {
            return process(a, start, middle - 1, key);
        } else if (key == a[middle] && (key != a[middle - 1]) ) {   // 如果相等，还要看它前面的数是否一样，1，2，3，3，3，3，4，5
//            while(middle - 1 >= start  && a[middle - 1] == key){  // O(N)
//                middle --;
//            }
            return middle;
        }
        return process(a, start, middle - 1, key);
//        return -1;
    }

    /**
     * 二分查找法 O(log N)
     * @param a 入参数组
     * @param key 要查找的数
     * @return 返回第一次出现的位置
     */
    public static int indexBinary(int[] a, int key) {
        if(key < a[0] || key > a[a.length - 1]) {
            return -1;
        }
        if(key == a[0]) { // 优化常数项
            return 0;
        }
        return process(a, 0, a.length, key);
    }

    /**
     * 顺序遍历 O(N)
     * @param a 入参数组
     * @param key 要查找的数
     * @return 返回第一次出现的位置
     */
    public static int index(int[] a, int key) {
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if(a[i] == key) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
//        int[] array = {0, 0, 0, 2, 2, 6, 9, 13, 14, 18, 23, 32, 32, 33, 33, 41, 44, 46, 48, 48};
//        int ans = 2;
        
//        int[] array = {8, 9, 9, 9, 10, 13, 17, 17, 19, 26, 28, 30, 30, 34, 39, 40, 42, 43, 44, 49};
//        int ans = 19;
//
//        int i1 = indexBinary(array, ans);
//        System.out.println(i1);

//        for (int i = 0; i < 20; i++) {
//            int[] arrs = generateArray(20, 50);
//            Arrays.sort(arrs);
//            System.out.println(Arrays.toString(arrs));
//        }

        int times = 1000000;
        int len = 20;
        int variable = 50;

        for (int i = 0; i < times; i++) {
            int[] arrs = generateArray(len, variable);
            Arrays.sort(arrs);
            System.out.println(Arrays.toString(arrs));

            int key = (int) (Math.random() * variable);
            System.out.println(key);

            int res1 = index(arrs, key);
            int res2 = indexBinary(arrs, key);
            if(res1 != res2) {
                System.out.println("Oops!");
                System.out.println("res1: " + res1);
                System.out.println("res2: " + res2);
                return;
            }
        }
        System.out.println("done.");
    }

    // for test
    public static int[] generateArray(int len, int varible) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * varible);
        }
        return arr;
    }

}
