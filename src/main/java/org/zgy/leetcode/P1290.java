package org.zgy.leetcode;

import java.util.HashMap;

/**
 * @Author z
 * @create 2022/6/28 11:17
 */
public class P1290 {

  public static void main(String[] args) {
    /*long a = 1011001001011L;
    long b;
    int i = 0;
    long res=0;

    while(a>0){
      i++;
      if(a%10==1){
        b=1;
        for (int j = 1; j < i; j++) {
          b*=2;
        }
        res+=b;
      }
      a/=10;
    }

    System.out.println(res);*/

    P1290 p1290 = new P1290();
    System.out.println(p1290.hashCode());
    HashMap<Object, Object> map = new HashMap<>();
    map.hashCode();
  }
}
