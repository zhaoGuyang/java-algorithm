package org.zgy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author z
 * @create 2022/7/25 10:52
 */
public class Codec4BinaryTree {

  public static void main(String[] args) {
//    Object[] objects = new Object[1];
//    objects[0]=null;
    Codec4BinaryTree codec = new Codec4BinaryTree();
//    String serialize = codec.serialize(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5))));
//    System.out.println(serialize);
//    TreeNode deserialize = codec.deserialize(serialize);
//    System.out.println(deserialize);

    String serialize = "[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]";
    TreeNode deserialize = codec.deserialize(serialize);
    System.out.println(deserialize);
    System.out.println(codec.serialize(deserialize));
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    //当前层的值输出，儿子层的值放入list
    ArrayList<TreeNode> nextLevelNodes = new ArrayList<>();
    ArrayList<TreeNode> curLevelNodes = new ArrayList<>();
    ArrayList<String> res = new ArrayList<>();
    while (root != null || curLevelNodes.size() > 0 || nextLevelNodes.size() > 0) {
      if (root != null) {
        res.add(root.val + "");
        nextLevelNodes.add(root.left);
        nextLevelNodes.add(root.right);
      } else {
        res.add(null);
      }
      if (curLevelNodes.isEmpty()) {
        curLevelNodes.addAll(nextLevelNodes);
        nextLevelNodes.clear();
      }
      root = curLevelNodes.remove(0);
    }

    //去掉末尾的空节点
    for (int i = res.size() - 1; i >= 0; i--) {
      if (res.get(i) == null) {
        res.remove(i);
      } else {
        break;
      }
    }
    return Arrays.toString(res.toArray());
  }

  //反序列化
  public TreeNode deserialize(String data) {
    String str = data.replaceFirst("\\[", "").replaceFirst("\\]", "");
    if (str.length() == 0) {
      return null;
    }
    String[] split = str.split(",");
    TreeNode res = null;
    ArrayList<TreeNode> upLevelNodes = new ArrayList<>();
    ArrayList<TreeNode> curLevelNodes = new ArrayList<>();
    TreeNode curNode;
    boolean isLeft = true;
    for (String val : split) {
      if ("null".equals(val.trim())) {
        curNode = null;
      } else {
        curNode = new TreeNode(Integer.valueOf(val.trim()));
        if (res == null) {
          res = curNode;
          upLevelNodes.add(curNode);
          continue;
        }
        curLevelNodes.add(curNode);
      }

      if (isLeft) {
        upLevelNodes.get(0).left = curNode;
        isLeft = false;
      } else {
        upLevelNodes.get(0).right = curNode;
        upLevelNodes.remove(0);
        if (upLevelNodes.isEmpty()) {
          upLevelNodes.addAll(curLevelNodes);
          curLevelNodes.clear();
        }
        isLeft = true;
      }
    }
    return res;
  }

  // Decodes your encoded data to tree.
 /* public TreeNode deserialize(String data) {
    String str = data.replaceFirst("\\[", "").replaceFirst("\\]", "");
    if(str.length()==0){
      return null;
    }
    String[] split = str.split(",");
    TreeNode res = null;
    ArrayList<TreeNode> upLevelNodes = new ArrayList<>();
    ArrayList<TreeNode> curLevelNodes = new ArrayList<>();
    int offset = 0;
    int curLevel = 0;
    int level;
    for (int i = 0; i < split.length; i++) {
      //求当前层数
      level = log(i + 1, 2);
      if (level > curLevel) {
        curLevel = level;
        upLevelNodes.clear();
        upLevelNodes.addAll(curLevelNodes);
        curLevelNodes.clear();
        offset=0;
      }

      TreeNode curNode;
      if ("null".equals(split[i].trim())) {
        curNode = null;
      } else {
        curNode = new TreeNode(Integer.valueOf(split[i].trim()));
      }

      //如果上一层不是空, 理论上只有第0层的上一层是空的
      if (!upLevelNodes.isEmpty()) {
        //计算当前第i个值是其父亲的左儿子还是右儿子
        double curIndex = (i - Math.pow(2, level) + 1) / 2;

        //计算当前第i个值的父亲是上一层的第几个node
        int upIndex = (int) curIndex;
        if (curIndex == upIndex) {
          while (upLevelNodes.get(upIndex+offset)==null){
            offset++;
          }
          upLevelNodes.get(upIndex+offset).left = curNode;
        } else {
          while (upLevelNodes.get(upIndex+offset)==null){
            offset++;
          }
          upLevelNodes.get(upIndex+offset).right = curNode;
        }
      } else {
        res = curNode;
      }
      curLevelNodes.add(curNode);
    }
    return res;
  }*/

//  private int log(double value, double base) {
//    return (int) (Math.log(value) / Math.log(base));
//  }
}