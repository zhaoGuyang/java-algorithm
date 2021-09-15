package org.zgy.zuo_algorithm_video2020.Video2;

/**
 * @Author z
 * @create 2021/9/7 17:07
 * 一个2进制数，提取出最右侧的1
 * 如110110011001000，得到000000000001000
 */
public class Problem3 {
  public static void main(String[] args) {
    //取反符号：~
    //8 取反是 -9, +1是-8,也可以不用取反，直接用-a, 8&-8就得到最右侧的1
    //"与"运算&：二进制每一位，不同为0，相同为1
    //"或"运算|：二进制每一位，有一个1结果就是1，没有1，结果就是0
    //"异或"运算^：二进制每一位，相同为0，不同为1
    //不确定的话，可以把每个数都转换成二进制看看
    int a = 10;
    System.out.println(Integer.toBinaryString(a));
    System.out.println(Integer.toBinaryString(~a+1));
    System.out.println(Integer.toBinaryString(-a));
    System.out.println(Integer.toBinaryString(a&(~a+1)));
  }
}
