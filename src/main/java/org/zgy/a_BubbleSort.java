package org.zgy;

/**
 * @Author z
 * @create 2021/5/31 14:58
 * 冒泡排序
 */
public class a_BubbleSort {

  public static void main(String[] args) {
    int [] nums = {1,6,3,26,2,67,2,6,2,8,2,1};
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        if(nums[i]>nums[j]){
          nums[i] = nums[i]+nums[j];
          nums[j] = nums[i]-nums[j];
          nums[i] = nums[i]-nums[j];
        }
      }
    }
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }
}
