package org.zgy.zuo_algorithm_video2020.Video3.stackAndQueue;

/**
 * @Author z
 * @create 2021/9/18 13:16
 */
public class DoubleEndsStack {

  //头节点
  DoubleNode headNode;
  //尾节点
  DoubleNode tailNode;

  Integer minVal = new Integer(0);

  public void push(int value) {
    DoubleNode curNode = new DoubleNode(value, null, null, minVal);
    if (headNode == null) {
      headNode = curNode;
      tailNode = curNode;
      minVal = value;
//      headNode.nextNode = tailNode;
//      tailNode.lastNode = headNode;
    } else {
      curNode.nextNode = headNode;
      headNode.lastNode = curNode;
      headNode = curNode;
      if (value < minVal) {
        minVal = value;
        headNode.minVal = value;
      }
    }
  }

  public Integer pop() {
    if (headNode == null) {
      return null;
    }
    DoubleNode<Integer> curNode = headNode;
    if (headNode == tailNode) {
      headNode = null;
      tailNode = null;
      minVal = null;
    } else {
      headNode = headNode.nextNode;
      headNode.lastNode = null;
      minVal = headNode.minVal;
    }

    return curNode.getValue();
  }

  public Integer getMin(){
    return minVal;
  }

  @Override
  public String toString() {
    return headNode.toString();
  }
}
