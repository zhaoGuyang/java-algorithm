package org.zgy.xiaohui.sort;

import java.util.Random;

/**
 * @Author z
 * @create 2021/5/31 15:05
 * 快速排序
 */
public class b_QuickSort {

  public static void main(String[] args) {
    int [] nums = {1,6,3,26,2,67,2,6,2,8,2,8};
    quickSort(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }

  /**
   * 快速排序，使得整数数组 arr 有序
   */
  public static void quickSort(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }
    quickSort(arr, 0, arr.length - 1);
  }

  /**
   * 快速排序，使得整数数组 arr 的 [L, R] 部分有序
   */
  public static void quickSort(int[] arr, int L, int R) {
    if(L < R) {
      // 把数组中随机的一个元素与最后一个元素交换，这样以最后一个元素作为基准值实际上就是以数组中随机的一个元素作为基准值
//      swap(arr, new Random().nextInt(R - L + 1) + L, R);
      int[] p = partition(arr, L, R);
      quickSort(arr, L, p[0] - 1);
      quickSort(arr, p[1] + 1, R);
    }
  }

  /**
   * 分区的过程，整数数组 arr 的[L, R]部分上，使得：
   *   大于 arr[R] 的元素位于[L, R]部分的右边，但这部分数据不一定有序
   *   小于 arr[R] 的元素位于[L, R]部分的左边，但这部分数据不一定有序
   *   等于 arr[R] 的元素位于[L, R]部分的中间
   * 返回等于部分的第一个元素的下标和最后一个下标组成的整数数组
   */
  public static int[] partition(int[] arr, int L, int R) {

    int basic = arr[R];
    int left = L - 1;
    int right = R + 1;
    while(L < right) {
      if(arr[L] < basic) {
        swap(arr, ++left, L++);
      } else if (arr[L] > basic) {
        swap(arr, --right, L);
      } else {
        L++;
      }
    }

    return new int[] { left + 1, right - 1 };

  }

  /*
   * 交换数组 arr 中下标为 i 和下标为 j 位置的元素
   */
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
