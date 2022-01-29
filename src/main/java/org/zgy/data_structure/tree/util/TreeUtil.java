package org.zgy.data_structure.tree.util;

import org.apache.commons.lang3.StringUtils;
import org.zgy.data_structure.tree.entity.BinaryTreeData;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 针对树结构的工具类
 *
 * @Author z
 * @create 2021/12/29 10:11
 */
public class TreeUtil {

  public static String[] treeArr = null;

  /**
   * 打印二叉树
   *
   * @param binaryTreeData
   */
  public static void printTree(BinaryTreeData binaryTreeData, int level) {
    if (treeArr == null) {
      treeArr = new String[getTreeLevel(binaryTreeData, 1)];
    }
    if (binaryTreeData == null || StringUtils.isBlank(binaryTreeData.getValue())) {
      return;
    }

    //前序遍历
//    treeArr[level] = (StringUtils.isNotBlank(treeArr[level])?treeArr[level]+genSpace(2):genSpace(treeArr.length-level))+binaryTreeData.getValue();
//    printTree(binaryTreeData.getLeftChild(), level + 1);
//    printTree(binaryTreeData.getRightChild(), level + 1);

    //中序遍历
//    printTree(binaryTreeData.getLeftChild(), level + 1);
//    treeArr[level] = (StringUtils.isNotBlank(treeArr[level]) ? treeArr[level] + genSpace(2) : genSpace(treeArr.length - level)) + (binaryTreeData.getLeftChild() != null ? genSpace((treeArr[level + 1].length() - (treeArr[level] != null ? treeArr[level].length() : 0)) / 2) : "") + binaryTreeData.getValue();
//    printTree(binaryTreeData.getRightChild(), level + 1);

    //后序遍历
    printTree(binaryTreeData.getLeftChild(), level + 1);
    printTree(binaryTreeData.getRightChild(), level + 1);
    treeArr[level] = (StringUtils.isNotBlank(treeArr[level]) ? treeArr[level] + genSpace(2) : genSpace(treeArr.length - level)) + (binaryTreeData.getLeftChild() != null ? genSpace((treeArr[level + 1].length() - (treeArr[level] != null ? treeArr[level].length() : 0)) / 2) : "") + binaryTreeData.getValue();
  }

  /**
   * 深度遍历
   * @param binaryTreeData
   */
  public static void printTree(BinaryTreeData binaryTreeData) {
    if (binaryTreeData == null || StringUtils.isBlank(binaryTreeData.getValue())) {
      return;
    }

    //前序遍历
    System.out.println(binaryTreeData.getValue());
    printTree(binaryTreeData.getLeftChild());
    printTree(binaryTreeData.getRightChild());

    //中序遍历
//    printTree(binaryTreeData.getLeftChild());
//    System.out.println(binaryTreeData.getValue());
//    printTree(binaryTreeData.getRightChild());

    //后序遍历
//    printTree(binaryTreeData.getLeftChild());
//    printTree(binaryTreeData.getRightChild());
//    System.out.println(binaryTreeData.getValue());
  }

  /**
   * 广度遍历
   * @param binaryTreeData
   */
  public static void printTreeByBreath(BinaryTreeData binaryTreeData) {
    if (binaryTreeData == null || StringUtils.isBlank(binaryTreeData.getValue())) {
      return;
    }
    Queue<BinaryTreeData> treeDataQueue = new LinkedList<>();
    treeDataQueue.offer(binaryTreeData);
    while (!treeDataQueue.isEmpty()){
      BinaryTreeData pollNode = treeDataQueue.poll();
      System.out.println(pollNode.getValue());
      if(pollNode.getLeftChild()!=null){
        treeDataQueue.offer(pollNode.getLeftChild());
      }
      if(pollNode.getRightChild()!=null){
        treeDataQueue.offer(pollNode.getRightChild());
      }
    }
  }

  private static String genSpace(int length) {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 1; i < length; i++) {
      stringBuffer.append("  ");
    }
    return stringBuffer.toString();
  }

  public static int getTreeLevel(BinaryTreeData binaryTreeData, int count) {
    if (binaryTreeData == null) {
      return count - 1;
    }
    int leftCount = getTreeLevel(binaryTreeData.getLeftChild(), count + 1);
    int rightCount = getTreeLevel(binaryTreeData.getRightChild(), count + 1);
    count = leftCount > rightCount ? leftCount : rightCount;
    return count;
  }

  public static void printLevel(int l) {
    if (l == 6) {
      return;
    }
    System.out.println(l);
    printLevel(l + 1);
    System.out.println(l);
  }

  public static void main(String[] args) {
    printLevel(1);
  }
}
