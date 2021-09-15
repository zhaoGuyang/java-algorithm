package org.zgy.zuo_algorithm_video2020.Video2;

/**
 * @Author z
 * @create 2021/9/7 17:31
 * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两种数
 */
public class Problem4 {

  public static void main(String[] args) {
    //理解：
    /*
     * 本题是题目2的升级版
     * 设这两个数是a、b，从头异或到尾，最后的结果eor一定是a^b
     * 找出eor最右侧的1，假设1位于倒数第三位，然后讲数组中的数分为两类，一类是倒数第三位=1的，一类是倒数第三位!=1的
     * 然后把其中一类数(二选一随意)从头异或到尾，结果eor2就是a或者b，然后用eor2^eor得到b或者a
     * */
    int[] arr = new int[]{3, 4, 5, 6, 3, 4, 5, 6, 7, 8, 7, 9, 8, 3};
    int eor = 0;
    for (int i : arr) {
      eor = eor ^ i;
    }

    int[] arr1 = new int[arr.length];
    int idx1 = 0;

    //1所处的位置，倒数第几个，不是正数第几个
//    int idxRight = Integer.toBinaryString(eor&-eor).length();

    //最后的1
    int eorP = eor & -eor;

    for (int i : arr) {
      //这句是为了找出idxRight这个位置是1的数，下面有简洁写法
      /*if('1'==(Integer.toBinaryString(i).toCharArray()[Integer.toBinaryString(i).length()-idxRight])){
        arr1[idx1] = i;
        idx1++;
      }*/

      if ((eorP & i) != 0) {
        arr1[idx1] = i;
        idx1++;
      }
    }
    int eor2 = 0;
    for (int i : arr1) {
      eor2 = eor2 ^ i;
    }

    System.out.println(eor2 + "," + (eor2 ^ eor));
  }
}
