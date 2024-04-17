/**
 * 递归分治算法学习之随机快速排序
 * 采用随机选择枢纽元素的快速排序算法
 * @author Sking
 */
package org.zgy.xiaohui.sort;

import java.util.Arrays;
public class my_QuickSort_1 {

  /**
   * 采用随机选取枢纽元素策略的一次快排后的划分索引
   * @param a 待排序数组
   * @param p 区间左端
   * @param r 区间右端
   * @return 采用随机选取枢纽元素策略的一次快排后的划分索引
   */
  @SuppressWarnings("rawtypes")
  private static int randomizedPartition(int[] a,int p,int r){
    return partition(a,p,r);
  }

  /**
   * 采用随机选取枢纽元素策略的快速排序
   * @param a 待排序数组
   * @param p 指定区间的左端
   * @param r 指定区间的右端
   */
  @SuppressWarnings({ "unused", "rawtypes" })
  public static   void randomizedQuickSort(int[] a,int p,int r){
    if(p<r){
      int q=randomizedPartition(a,p,r);
      randomizedQuickSort(a,p,q-1);
      randomizedQuickSort(a,q+1,r);
    }
  }

  /**
   * 求划分索引
   * @param a 待排序数组
   * @param p 区间左端
   * @param r 区间右端
   * @return 划分索引
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  private static int partition(int[] a,int p,int r){
    int i=p,j=r+1;
    int x=a[p];
    while(true){
      while(a[++i] < x&&i<r);
      while(a[--j]> x);
      if(i>=j)break;
      swap(a,i,j);
    }
    a[p]=a[j];
    a[j]=x;
    return j;
  }

  /**
   *
   * @param a
   * @param i
   * @param j
   */
  @SuppressWarnings("rawtypes")
  private  static void swap(int[] a,int i,int j){
    int temp=a[i];
    a[i]=a[j];
    a[j]=temp;
  }
  public static void main(String[] args){
    int[] ints = {1, 67, 3, 26, 2, 6, 2, 6, 2, 8, 2, 8};
    randomizedQuickSort(ints,0,11);
    System.out.println(Arrays.toString(ints));
  }
}