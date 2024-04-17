package org.zgy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author z
 * @create 2022/11/16 17:09
 */
public class Test {
}

class MovingAverage{

  Integer idleSize;
  Integer windowSize;

  List<Double> memberList;
  Double memberSum;

  public MovingAverage(int size) {
    this.windowSize = size;
    this.memberList = new ArrayList<>(size);
    this.idleSize=0;
    this.memberSum=0.0;
  }

  public double next(int val) {
    if(!addIdleSize()){
      this.memberSum-=this.memberList.get(0);
      this.memberList.remove(0);
    }
    this.memberSum+=val;
    this.memberList.add((double)val);
    return this.memberSum/this.idleSize;
  }

  private boolean addIdleSize(){
    if(idleSize<windowSize){
      idleSize++;
      return true;
    }else{
      return false;
    }
  }

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    System.out.println(list.get(0));
    list.remove(0);
    System.out.println(list.get(0));
  }
}