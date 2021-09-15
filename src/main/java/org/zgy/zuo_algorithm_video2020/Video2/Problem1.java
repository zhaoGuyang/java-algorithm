package org.zgy.zuo_algorithm_video2020.Video2;

/**
 * @Author z
 * @create 2021/9/7 15:38
 * 题目：不用额外的变量，交换两个数的值
 */
public class Problem1 {

  public static void main(String[] args) {
    int a=17;
    int b=5;
    a = a^b;
    b = a^b;
    a = a^b;
    System.out.println(a);
    System.out.println(b);
  }
}
