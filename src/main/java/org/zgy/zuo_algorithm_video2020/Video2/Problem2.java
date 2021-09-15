package org.zgy.zuo_algorithm_video2020.Video2;

/**
 * @Author z
 * @create 2021/9/7 17:01
 * 一个数组中，有一个数出现了奇数次，其他数都出现了偶数次，找出这个数
 */
public class Problem2 {
  public static void main(String[] args) {
    int[] arr = new int[]{3,4,5,6,3,4,5,6,7,8,7,9,8};
    int eor = 0;
    for (int i : arr) {
      eor=eor^i;
    }
    System.out.println(eor);
  }
}
