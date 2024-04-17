package org.zgy.usual_algorithms.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author z
 * @create 2023/7/26 10:58
 */
public class lc_P118 {

  public static void main(String[] args) {
    System.out.println(new lc_P118().generate(5));
  }

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> list = new ArrayList<>();
    ArrayList<Integer> innerList;
    ArrayList<Integer> perInnerList = null;
    for (int i = 0; i < numRows; i++) {
      innerList = new ArrayList<>();
      if (i < 2) {
        for (int i1 = 0; i1 <= i; i1++) {
          innerList.add(1);
        }
      } else {
        for (int i1 = 0; i1 <= perInnerList.size(); i1++) {
          if (i1 == 0 || i1 == perInnerList.size()) {
            innerList.add(1);
          } else {
            innerList.add(perInnerList.get(i1 - 1) + perInnerList.get(i1));
          }
        }
      }

      list.add(innerList);
      perInnerList = innerList;
    }
    return list;
  }
}
