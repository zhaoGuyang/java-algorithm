package org.zgy.zuo_algorithm_video2020.Video3.linked;

/**
 * @Author z
 * @create 2021/9/15 8:11
 */
public class Test {

  public static void main(String[] args) {
    int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    /*SingleNode node = null;
    SingleNode nextNode = null;
    for (int i = a.length-1; i >= 0; i--) {
      node = new SingleNode(a[i], nextNode);
      nextNode = node;
    }

    System.out.println("反转前："+node);
    SingleNode reverse = reverse(node);
    System.out.println("反转后："+reverse);*/

    /*SingleNode node = null;
    SingleNode nextNode = null;
    for (int i = a.length-1; i >= 0; i--) {
      node = new SingleNode(a[i], nextNode);
      nextNode = node;
    }

    System.out.println("删除前："+node);
    SingleNode node1 = removeVal(node, 4);
    System.out.println("删除后："+node1);*/

    /*DoubleNode node = null;
    DoubleNode lastNode = null;
    DoubleNode nextNode = null;
    for (int i = a.length - 1; i >= 0; i--) {
      node = new DoubleNode(a[i], lastNode, nextNode);
      if (nextNode != null) {
        nextNode.lastNode = node;
      }
      nextNode = node;
    }
    System.out.println("反转前：" + node);
    DoubleNode reverse = reverse(node);
    System.out.println("反转后：" + reverse);*/
    DoubleNode node = null;
    DoubleNode lastNode = null;
    DoubleNode nextNode = null;
    for (int i = a.length - 1; i >= 0; i--) {
      node = new DoubleNode(a[i], lastNode, nextNode);
      if (nextNode != null) {
        nextNode.lastNode = node;
      }
      nextNode = node;
    }
    System.out.println("删除前：" + node);
    DoubleNode node1 = removeVal(node, 9);
    System.out.println("删除后：" + node1);
  }


  /**
   * 反转单链表
   *
   * @param node
   * @return
   */
  public static SingleNode reverse(SingleNode node) {
    if (node == null || node.nextNode == null) {
      return node;
    }

    SingleNode curNode = node;
    SingleNode nextNode;
    SingleNode lastNode = null;
    while (curNode != null) {
      nextNode = curNode.nextNode;
      curNode.nextNode = lastNode;
      lastNode = curNode;
      curNode = nextNode;
    }
    return lastNode;
  }

  /**
   * 反转双链表
   *
   * @param node
   * @return
   */
  public static DoubleNode reverse(DoubleNode node) {
    if (node == null || node.nextNode == null) {
      return node;
    }
    DoubleNode curNode = node;
    DoubleNode nextNode = null;
    while (curNode != null) {
      nextNode = curNode.nextNode;
      curNode.nextNode = curNode.lastNode;
      curNode.lastNode = nextNode;
      if(nextNode==null){
        break;
      }
      curNode = nextNode;
    }
    return curNode;
  }


  /**
   * 移除单链表指定值
   *
   * @param node
   * @return
   */
  public static SingleNode removeVal(SingleNode node,int value) {
    if (node == null) {
      return node;
    }
    SingleNode lastNode = node;
    SingleNode nextNode = node;
    while (node!=null){
      if(nextNode.value==value){
        lastNode.nextNode=nextNode.nextNode;
        break;
      }
      lastNode = nextNode;
      nextNode = nextNode.nextNode;
    }
    return node;
  }

  /**
   * 移除双链表指定值
   *
   * @param node
   * @return
   */
  public static DoubleNode removeVal(DoubleNode node,int value) {
    if (node == null) {
      return node;
    }
    DoubleNode lastNode = node;
    DoubleNode nextNode = node;
    while (node!=null){
      if(nextNode.value==value){
        lastNode.nextNode=nextNode.nextNode;
        nextNode.nextNode.lastNode=lastNode;
        break;
      }
      lastNode = nextNode;
      nextNode = nextNode.nextNode;
    }
    return node;
  }
}
