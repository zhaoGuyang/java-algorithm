package org.zgy.zuo_algorithm_video2020.Video2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author z
 * @create 2021/9/8 11:43
 * 一个数组中有一种数出现K次,其他数都出现了M次,
 * M>1，K<M
 * 找到,出现了K次的数,
 * 要求,额外空间复杂度O(1),时间复杂度O(N)
 */
public class Problem5 {

  public static void main(String[] args) {
    int kinds;
    int k;
    int m;

    int testTimes = 1000000;
    long myTime = 0;
    long testTime = 0;

    long startTime;

    for (int i = 0; i < testTimes; i++) {
      kinds = randomNumber(20)+3;
      m = randomNumber(20)+2;
      k = randomNumber(m);
      int[] ints = randomArray(10*kinds, kinds, k, m);
      if(ints==null){
        System.out.println("null "+i);
        continue;
      }
//      System.out.println(i);
      startTime = System.currentTimeMillis();
      int kTimesNumber = findKTimesNumber(ints, k, m);
      myTime+=(System.currentTimeMillis()-startTime);
      startTime = System.currentTimeMillis();
      int comparison = comparison(ints, k, m);
      testTime+=(System.currentTimeMillis()-startTime);
      if(kTimesNumber!=comparison){
        System.out.println("ops,出错了");
      }
    }
    System.out.println("我的方法总耗时："+myTime);
    System.out.println("对数器总耗时："+testTime);
    System.out.println("我的方法平均耗时："+(double)myTime/(double)testTimes);
    System.out.println("对数器平均耗时："+(double)testTime/(double)testTimes);

//    int[] ints = randomArray(numberRange, kinds, k, m);

//    System.out.println("function result: "+findKTimesNumber(ints, k, m));
//    System.out.println("comparison result: "+comparison(ints, k, m));
  }

  public static int comparison(int[] arr, int k, int m){
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i : arr) {
      if(map.containsKey(i)){
        map.put(i,map.get(i)+1);
      }else{
        map.put(i,1);
      }
    }
    for (Integer num : map.keySet()) {
      if(map.get(num)==k){
        return num;
      }
    }
    return 0;
  }

  public static int findKTimesNumber(int[] arr, int k, int m) {
    int[] binaryArr = new int[32];//为什么是32，因为int类型转成二进制，最长是32位
    for (int i = 0; i < arr.length; i++) {
      for (int i1 = 0; i1 < binaryArr.length; i1++) {
        //这句是取arr[i]的二进制数，第i1位是1或0都累加
        //arr[i]>>i1这句是把当前要取的第i1位，移到最低位，然后"与"1，如果是1就返回1，如果是0就返回0
        binaryArr[i1] += (arr[i] >> i1) & 1;
      }
    }
    int ans = 0;

    for (int i = 0; i < binaryArr.length; i++) {
      if(binaryArr[i]%m!=0){
        ans += 1 << i;
      }
    }

    return ans;
  }

  public static int[] randomArray(int numberRange, int kinds, int k, int m) {

    if (kinds <= 2 || m < 2) {
      return null;
    }

    int[] result = new int[k + m * (kinds - 1)];
    int idx = 0;

    //准备kinds种数值
    ArrayList<Integer> kindNums = new ArrayList<>(kinds);
    for (int i = 0; i < kinds; i++) {
      int num;
      do {
        num = randomNumber(numberRange);
      } while (kindNums.contains(num));
      kindNums.add(num);
    }
    System.out.print("");
    for (int i = 0; i < kindNums.size(); i++) {
      if (i == 0) {
        for (int i1 = 0; i1 < k; i1++) {
          result[idx++] = kindNums.get(i);
        }
      } else {
        for (int i1 = 0; i1 < m; i1++) {
          result[idx++] = kindNums.get(i);
        }
      }
    }
    /*System.out.print("[ ");
    for (int i : result) {
      System.out.print(i + " ");
    }
    System.out.println("]");*/

    //打乱数组内顺序
    for (int i = 0; i < result.length - 1; i++) {
      int index = randomNumber(result.length - i) + i;
      if (index != i) {
        result[i] = result[i] ^ result[index];
        result[index] = result[i] ^ result[index];
        result[i] = result[i] ^ result[index];
      }
    }
    return result;

  }

  public static int randomNumber(int range) {
    return (int) (Math.random() * range);
  }
}
