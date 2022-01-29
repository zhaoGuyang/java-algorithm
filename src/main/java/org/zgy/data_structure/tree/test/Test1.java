package org.zgy.data_structure.tree.test;

import org.apache.commons.lang3.StringUtils;
import org.zgy.data_structure.tree.entity.BinaryTreeData;
import org.zgy.data_structure.tree.util.TreeUtil;
import sun.reflect.generics.tree.Tree;

/**
 * 二叉树的创建&遍历
 * (父->左子->右子)
 * @Author z
 * @create 2021/12/29 10:08
 */
public class Test1 {

  public static void main(String[] args) {
    BinaryTreeData binaryTreeDataL = new BinaryTreeData();
    BinaryTreeData binaryTreeDataR = new BinaryTreeData();
    BinaryTreeData binaryTreeData = new BinaryTreeData();

    binaryTreeDataL.setValue("L");

    binaryTreeDataR.setValue("R");

    binaryTreeData.setValue("root");
    binaryTreeData.setLeftChild(binaryTreeDataL);
    binaryTreeData.setRightChild(binaryTreeDataR);

    BinaryTreeData binaryTreeDataL1 = new BinaryTreeData();
    binaryTreeDataL1.setValue("L1");
    binaryTreeDataL.setLeftChild(binaryTreeDataL1);

    BinaryTreeData binaryTreeDataL2 = new BinaryTreeData();
    binaryTreeDataL2.setValue("L2");
    binaryTreeDataL.setRightChild(binaryTreeDataL2);

    BinaryTreeData binaryTreeDataR1 = new BinaryTreeData();
    binaryTreeDataR1.setValue("R1");
    binaryTreeDataR.setLeftChild(binaryTreeDataR1);

    BinaryTreeData binaryTreeDataR11 = new BinaryTreeData();
    binaryTreeDataR11.setValue("R11");
    binaryTreeDataR1.setLeftChild(binaryTreeDataR11);

    //深-带样式的
//    TreeUtil.printTree(binaryTreeData,0);
//    for (String s : TreeUtil.treeArr) {
//      System.out.println(s);
//    }
    //深-不带样式的
    TreeUtil.printTree(binaryTreeData);

    //广-不带样式的
    TreeUtil.printTreeByBreath(binaryTreeData);
  }
}
