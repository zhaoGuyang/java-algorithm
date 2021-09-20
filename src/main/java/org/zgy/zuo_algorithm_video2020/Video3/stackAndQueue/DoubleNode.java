package org.zgy.zuo_algorithm_video2020.Video3.stackAndQueue;

/**
 * @Author z
 * @create 2021/9/15 8:10
 */
public class DoubleNode<T> {

  T value;
  DoubleNode lastNode;
  DoubleNode nextNode;
  int minVal;

  public DoubleNode(T value, DoubleNode lastNode, DoubleNode nextNode,int minVal) {
    this.value = value;
    this.lastNode = lastNode;
    this.nextNode = nextNode;
    this.minVal = minVal;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public DoubleNode getLastNode() {
    return lastNode;
  }

  public void setLastNode(DoubleNode lastNode) {
    this.lastNode = lastNode;
  }

  public DoubleNode getNextNode() {
    return nextNode;
  }

  public void setNextNode(DoubleNode nextNode) {
    this.nextNode = nextNode;
  }

  public int getMinVal() {
    return minVal;
  }

  public void setMinVal(int minVal) {
    this.minVal = minVal;
  }

  @Override
  public String toString() {
    DoubleNode next = this;
    StringBuffer stringBuffer = new StringBuffer("[");
    while (next != null) {
      if (next.nextNode != null && next.nextNode.lastNode != next) {
//        throw new RuntimeException("双链表节点" + next.value + "，结构有问题，请排查");
        System.out.println("双链表节点" + next.value + "，结构有问题"+next.getValue()+"=="+next.nextNode.lastNode.getValue()+"，请排查");
      }
      stringBuffer.append(" ").append(next.getValue());
      next = next.nextNode;
    }
    stringBuffer.append(" ]");
    return stringBuffer.toString();
  }
}
