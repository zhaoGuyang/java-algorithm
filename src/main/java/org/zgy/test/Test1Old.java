package org.zgy.test;

import java.util.Arrays;
import java.util.Random;

public class Test1Old {

  /**
   * 已知一个有序大数组,查找一个值在这个有序数组中第一次出现的位置:
   * 如[1, 2, 3, 3, 4, 4, 4, 5, ..., n] 中4 第一次出现的位置是  4
   * <p>
   * public int index(int[] a, int key) {
   * }
   */
  public static int process(int[] a, int start, int end, int key) {
    System.out.println("process");
    if (start > end) {
      return -1;
    }
    if (start == end) {
      if (a[end] == key) {
        return end;
      } else {
        return -1;
      }
    }
//        int index = -1;
    int middle = (start + end) / 2;
    if (key > a[middle]) {
      return process(a, middle + 1, end, key);
    } else if (key < a[middle]) {
      return process(a, start, middle - 1, key);
    } else if (key == a[middle] && ((middle - 1) < 0 || a[middle - 1] != key)) {
      return middle;
    } else if (key == a[middle] && (middle - 1) >= 0 && a[middle - 1] == key) {
      return process(a, start, middle - 1, key);
    }
    return -1;
  }

  public static int indexBinary(int[] a, int key) {
    if (key < a[0] || key > a[a.length - 1]) {
      return -1;
    }
    if (key == a[0]) {
      return 0;
    }
    int index = process(a, 0, a.length, key);
    return index;
  }

  public static int index(int[] a, int key) {
    int index = -1;
    for (int i = 0; i < a.length; i++) {
      if (a[i] == key) {
        index = i;
        break;
      }
    }
    return index;
  }

  public static void main(String[] args) {
//        int[] array = {0, 0, 0, 2, 2, 6, 9, 13, 14, 18, 23, 32, 32, 33, 33, 41, 44, 46, 48, 48};
//        int ans = 2;
//
//        int i1 = indexBinary(array, ans);
//        System.out.println(i1);

//        for (int i = 0; i < 20; i++) {
//            int[] arrs = generateArray(20, 50);
//            Arrays.sort(arrs);
//            System.out.println(Arrays.toString(arrs));
//        }


    for (int i = 0; i < 100000; i++) {
      int[] arrs = generateArray(20, 50);
      Arrays.sort(arrs);
//            System.out.println(Arrays.toString(arrs));
      arrs = new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 13, 13, 15, 22, 27, 29, 33, 40, 41, 42, 49};

      int val = new Random().nextInt();
      int key = val % 10 + 10;
//            System.out.println(key);

      key = 2;

      int res1 = index(arrs, key);
      int res2 = indexBinary(arrs, key);
      if (res1 != res2) {
        System.out.println("Oops!");
        System.out.println("res1: " + res1);
        System.out.println("res2: " + res2);
        break;
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
