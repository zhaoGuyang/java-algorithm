package org.zgy.luogu.studyingfather841;

/**
 * @Author z
 * @create 2021/10/9 14:46
 * 题目：班主任给小玉一个任务，到文具店里买尽量多的签字笔。已知一只签字笔的价格是 1 元 9 角，而班主任给小玉的钱是 a 元 b 角，小玉想知道，
 * 她最多能买多少只签字笔呢。
 *
 * 输入：输入只有一行两个整数，分别表示 a 和 b。
 * 输出：一行一个整数，表示小玉最多能买多少只签字笔。
 */
public class P1421 {

  public static void main(String[] args) {
    System.out.println(func(10,3));
  }

  public static int func(int a,int b){
    double money = a+(b/10.00);

    return (int) (money / 1.9);
  }
}
