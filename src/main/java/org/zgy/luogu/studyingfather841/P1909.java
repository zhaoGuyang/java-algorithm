package org.zgy.luogu.studyingfather841;

/**
 * @Author z
 * @create 2021/10/9 15:09
 * 题目：老师要买n个铅笔，商店有3种包装的铅笔，每种包装根数不同，每种不能拆开买，老师只能买同一种铅笔。求最少花多少钱?
 * 输入：n铅笔数，三对数，每对表示一种铅笔的数量和价格
 * 输出：最少花费的钱
 */
public class P1909 {

  public static void main(String[] args) {
    Pencil[] pencils = {new Pencil(128 , 233), new Pencil(128 , 2333), new Pencil(128 , 666)};
    System.out.println(func(9998, pencils));
  }

  public static int func(int n, Pencil[] pencils) {
    int minMoney = -1;
    int curMoney;
    int needNum;
    for (Pencil pencil : pencils) {
      curMoney = 0;
      needNum = n;
      while (pencil.num < needNum) {
        curMoney+=pencil.money;
        needNum-=pencil.num;
      }
      if(needNum!=0){
        curMoney+=pencil.money;
      }
      if(curMoney<minMoney||minMoney==-1){
        minMoney=curMoney;
      }
    }
    return minMoney;
  }
}

class Pencil {

  public Pencil(int num, int money) {
    this.num = num;
    this.money = money;
  }

  int num;
  int money;

}
