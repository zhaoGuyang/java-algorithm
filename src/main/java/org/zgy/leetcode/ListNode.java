package org.zgy.leetcode;

import java.util.HashMap;

/**
 * @Author z
 * @create 2022/7/18 10:26
 */
public class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  ListNode(int[] arr) {
    ListNode ln = null;
    for (int i = arr.length - 1; i > 0; i--) {
      ln = new ListNode(arr[i], ln);
    }
    this.val = arr[0];
    this.next = ln;
  }

  /**
   * pos是环索引，如果链表中有环的话，pos就是那个环指的位置
   *
   * @param arr
   * @param pos
   */
  ListNode(int[] arr, int pos) {
    ListNode ln = null;
    ListNode lnPos = null;
    ListNode lnLast = null;
    for (int i = arr.length - 1; i > 0; i--) {
      ln = new ListNode(arr[i], ln);
      if (lnLast == null) {
        lnLast = ln;
      }
      if (i == pos) {
        lnPos = ln;
      }
    }
    lnLast.next = lnPos;
    this.val = arr[0];
    this.next = ln;
  }

  @Override
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();
    ListNode ln = this;
    //加个map防止链表中有环，避免死循环
    HashMap<ListNode, Integer> map = new HashMap<>();
    while (ln!=null){
      if(map.containsKey(ln)){
        break;
      }
      stringBuffer.append(", ").append(ln.val);
      map.put(ln,0);
      ln = ln.next;
    }
    return stringBuffer.toString().replaceFirst(", ", "");
  }
}
