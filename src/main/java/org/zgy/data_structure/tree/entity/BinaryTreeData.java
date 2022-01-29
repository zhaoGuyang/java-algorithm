package org.zgy.data_structure.tree.entity;

/**
 * 二叉树
 *
 * @Author z
 * @create 2021/12/29 10:01
 */
public class BinaryTreeData {
  private String value;
  private BinaryTreeData leftChild;
  private BinaryTreeData rightChild;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public BinaryTreeData getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(BinaryTreeData leftChild) {
    this.leftChild = leftChild;
  }

  public BinaryTreeData getRightChild() {
    return rightChild;
  }

  public void setRightChild(BinaryTreeData rightChild) {
    this.rightChild = rightChild;
  }
}