package com.java.trees;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
  public int value;
  public List children = new LinkedList();

  public TreeNode(int rootValue) {
    value = rootValue;
  }

}
