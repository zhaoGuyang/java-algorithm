package org.zgy.zuo_algorithm_video2020.Video3.linked;

/**
 * @Author z
 * @create 2021/9/15 8:09
 */
public class SingleNode {

  int value;
  SingleNode nextNode;

  public SingleNode() {
  }

  public SingleNode(int value, SingleNode nextNode) {
    this.value = value;
    this.nextNode = nextNode;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public SingleNode getNextNode() {
    return nextNode;
  }

  public void setNextNode(SingleNode nextNode) {
    this.nextNode = nextNode;
  }

  @Override
  public String toString() {
    SingleNode next = this;
    StringBuffer stringBuffer = new StringBuffer("[");
    while (next!=null){
      stringBuffer.append(" ").append(next.getValue());
      next = next.nextNode;
    }
    stringBuffer.append(" ]");
    return stringBuffer.toString();
  }
}
