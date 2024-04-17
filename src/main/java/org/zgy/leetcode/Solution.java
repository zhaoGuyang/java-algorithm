package org.zgy.leetcode;


import java.util.HashMap;

public class Solution {

  public static void main(String[] args) {

    System.out.println(new Solution().candy(new int[]{1, 3, 2, 2, 1}));
  }

  /**
   * 采用数组左右双指针策略，因为头尾的数字只需要和一个挨着的兄弟判断大小就能得出糖果数
   *
   * @param ratings
   * @return
   */
  public int candy(int[] ratings) {
    candyHelper(ratings,0);
    return res;
  }


  int res=0;
  HashMap<Integer,Integer> map = new HashMap<>();

  void candyHelper(int[] ratings,int index) {
    if(map.containsKey(index)||index<0||index>=ratings.length){
      return;
    }
    if(ratings[index]>ratings[index-1]){}
  }
}