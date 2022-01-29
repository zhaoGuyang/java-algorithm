package org.zgy.zuo_algorithm_video2020.Video3.stackAndQueue;

/**
 * @Author z
 * @create 2021/9/18 13:16
 */
public class Test {

  public static void main(String[] args) {
    //双链表队列
    /*DoubleEndsQueue<Integer> headQueue = new DoubleEndsQueue<>();
    DoubleEndsQueue<Integer> tailQueue = new DoubleEndsQueue<>();
    for (int i = 0; i < 10; i++) {
      headQueue.addToHead(i);
      tailQueue.addToTail(i);
    }
    System.out.println(headQueue);
    System.out.println(tailQueue);

    for (int i = 0; i < 10; i++) {
      System.out.println(headQueue.popFromTail());
    }
    for (int i = 0; i < 10; i++) {
      System.out.println(tailQueue.popFromTail());
    }

    System.out.println(headQueue);
    System.out.println(tailQueue);*/

    //双链表栈
    /*DoubleEndsStack integerDoubleEndsStack = new DoubleEndsStack();
    for (int i = 10; i > 0; i--) {
      integerDoubleEndsStack.push(i);
    }
    System.out.println(integerDoubleEndsStack.headNode);
    for (int i = 0; i < 10; i++) {
      System.out.println(integerDoubleEndsStack.pop()+",min:"+integerDoubleEndsStack.getMin());
    }*/

    //数组队列
    /*ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<>(10);
    for (int i = 0; i < 10; i++) {
      integerArrayQueue.push(i);
    }
    System.out.println(integerArrayQueue);
    for (int i = 0; i < 10; i++) {
      System.out.println(integerArrayQueue.pop());
    }
    integerArrayQueue.pop();*/

    //数组栈
    ArrayStack<Integer> integerArrayStack = new ArrayStack<>(10);
    for (int i = 0; i < 10; i++) {
      integerArrayStack.push(i);
    }
    System.out.println(integerArrayStack);
    for (int i = 0; i < 10; i++) {
      System.out.println(integerArrayStack.pop());
    }
//    integerArrayStack.pop();
  }
}
