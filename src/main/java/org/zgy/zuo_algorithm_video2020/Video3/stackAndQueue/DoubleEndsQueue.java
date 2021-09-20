package org.zgy.zuo_algorithm_video2020.Video3.stackAndQueue;

/**
 * @Author z
 * @create 2021/9/18 13:16
 */
public class DoubleEndsQueue<T> {

  //头节点
  DoubleNode headNode;
  //尾节点
  DoubleNode tailNode;

  public void addToHead(T value){
    DoubleNode curNode = new DoubleNode(value, null, null,0);
    if(headNode==null){
      headNode = curNode;
      tailNode = curNode;
//      headNode.nextNode = tailNode;
//      tailNode.lastNode = headNode;
    }else{
      curNode.nextNode=headNode;
      headNode.lastNode = curNode;
      headNode=curNode;
    }
  }

  public void addToTail(T value){
    DoubleNode curNode = new DoubleNode(value, null, null,0);
    if(tailNode==null){
      headNode = curNode;
      tailNode = curNode;
//      headNode.nextNode = tailNode;
//      tailNode.lastNode = headNode;
    }else{
      curNode.lastNode=tailNode;
      tailNode.nextNode = curNode;
      tailNode=curNode;
    }
  }

  public T popFromHead(){
    if(headNode==null){
      return null;
    }
    DoubleNode<T> curNode = headNode;
    if(headNode==tailNode){
      headNode=null;
      tailNode=null;
    }else{
      headNode = headNode.nextNode;
      headNode.lastNode=null;
    }

    return curNode.getValue();
  }

  public T popFromTail(){
    if(tailNode==null){
      return null;
    }
    DoubleNode<T> curNode = tailNode;
    if(headNode==tailNode){
      headNode=null;
      tailNode=null;
    }else{
      tailNode = tailNode.lastNode;
      tailNode.nextNode=null;
    }

    return curNode.getValue();
  }

  @Override
  public String toString() {
    return headNode.toString();
  }
}
