package org.zgy.xiaohui.sort;

/**
 * @Author z
 * @create 2022/2/16 10:16
 */
public class xiaohui_QuickSort {

  public static void sort(int[] arr, int startIndex, int endIndex) {
    if (startIndex >= endIndex) {
      return;
    }
    // 取第1个位置（也可以选择随机位置）的元素作为基准元素
    int pivot = arr[startIndex];
    int left = startIndex;
    int right = endIndex;

    while (left != right) {
      //控制right 指针比较并左移
      while (left < right && arr[right] > pivot) {
        right--;
      }
      //控制left指针比较并右移
      while (left < right && arr[left] <= pivot) {
        left++;
      }
      //交换left和right 指针所指向的元素
      if (left < right) {
        /*int p = arr[left];
        arr[left] = arr[right];
        arr[right] = p;*/
        swapArray(arr,left,right);
      }
    }

    //pivot 和指针重合点交换
//    arr[startIndex] = arr[left];
//    arr[left] = pivot;
    swapArray(arr,startIndex,left);
    sort(arr, startIndex, left - 1);
    sort(arr, left + 1, endIndex);
  }

  /*private static int partition(int[] arr, int startIndex, int endIndex) {
    // 取第1个位置（也可以选择随机位置）的元素作为基准元素
    int pivot = arr[startIndex];
    int left = startIndex;
    int right = endIndex;

    while (left != right) {
      //控制right 指针比较并左移
      while (left < right && arr[right] > pivot) {
        right--;
      }
      //控制left指针比较并右移
      while (left < right && arr[left] <= pivot) {
        left++;
      }
      //交换left和right 指针所指向的元素
      if (left < right) {
        *//*int p = arr[left];
        arr[left] = arr[right];
        arr[right] = p;*//*
        swapArray(arr,left,right);
      }
    }

    //pivot 和指针重合点交换
    arr[startIndex] = arr[left];
    arr[left] = pivot;

    return left;
  }*/

  public static void swapArray(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
}
