package org.zgy.luogu.studyingfather841;

/**
 * @Author z
 * @create 2021/10/9 17:13
 * <p>
 * 题目：试计算在区间 1 到 n 的所有整数中，数字 xx（0\le x\le90≤x≤9）共出现了多少次？例如，在 1 到 11 中，
 * 即在 1,2,3,4,5,6,7,8,9,10,11 中，数字 1 出现了 4 次。
 * <p>
 * 输入：2 个整数 n,x，之间用一个空格隔开。
 * 输出：1 个整数，表示 x 出现的次数。
 */
public class P1980 {

  public static void main(String[] args) {
    System.out.println(func1(20, 1));
  }

  public static int func(int n, int x) {
    int a = 1;
    //除了个位，每一位都有9个1+自身的10个1，也就是19个1，个位只有1个1，百位有
    return 0;
  }

  /**
   * 对数器
   *
   * @param n
   * @param x
   * @return
   */
  public static int func1(int n, int x) {
    /*int count=0; //位数
    int num = n;
    while(num>=1) {
      num/=10;
      count++;
    }*/

    int cnt = 0;

    for (int i = 1; i <= n; i++) {
      /*for (int i1 = 1; i1 <= count; i1++) {
        if(i%(10^count)==x){
          cnt++;
        }
      }*/
      int d = i;
      while (d > 0) {
        int c = d % 10;
        d = d / 10;
        if (c == x) {
          cnt++;
        }
      }
    }
    return cnt;
  }
}
