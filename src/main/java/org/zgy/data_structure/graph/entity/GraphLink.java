package org.zgy.data_structure.graph.entity;

/**
 * @Author z
 * @create 2021/12/29 15:54
 */
public class GraphLink {
  public Node first;
  public Node last;

  public boolean isEmpty() {
    return first == null;
  }

  public void print() {
    Node current = first;
    while (current != null) {
      System.out.print("[" + current.x + "]");
      current = current.next;
    }
    System.out.println();
  }

  public void insert(int x) {
    Node newNode = new Node(x);
    if (this.isEmpty()) {
      first = newNode;
      last = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
  }
}

class Node {
  int x;
  Node next;

  public Node(int x) {
    this.x = x;
    this.next = null;
  }
}
