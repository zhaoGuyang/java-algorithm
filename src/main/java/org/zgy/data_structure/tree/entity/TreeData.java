package org.zgy.data_structure.tree.entity;

import java.util.List;

/**
 * 不定叉树
 * @Author z
 * @create 2021/12/29 10:01
 */
public class TreeData {
  private String id;
  private String value;
  private String pId;
  private List<TreeData> child;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getpId() {
    return pId;
  }

  public void setpId(String pId) {
    this.pId = pId;
  }

  public List<TreeData> getChild() {
    return child;
  }

  public void setChild(List<TreeData> child) {
    this.child = child;
  }

  @Override
  public String toString() {
    return "TreeData{" +
        "id='" + id + '\'' +
        ", value='" + value + '\'' +
        ", pId='" + pId + '\'' +
        ", child=" + child +
        '}';
  }
}