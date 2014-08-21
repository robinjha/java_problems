package com.java.trees;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;

public class PairsToTree {

  public static void main(String[] args) throws Exception {
    // Create the child to parent hash map
    Map childParentMap = new HashMap(10);
    childParentMap.put(9, 10);
    childParentMap.put(8, 10);
    childParentMap.put(7, 10);
    childParentMap.put(6, 9);
    childParentMap.put(5, 9);
    childParentMap.put(4, 8);
    childParentMap.put(3, 8);
    childParentMap.put(2, 7);
    childParentMap.put(1, 7);

    // All children in the tree
    Collection children = childParentMap.keySet();

    // All parents in the tree
    Collection values = childParentMap.values();

    // Using extra space here as any changes made to values will
    // directly affect the map
    Collection clonedValues = new HashSet();
    for (Integer value : values) {
      clonedValues.add(value);
    }

    // Find parent which is not a child to any node. It is the
    // root node
    clonedValues.removeAll(children);

    // Some error handling
    if (clonedValues.size() != 1) {
      throw new Exception("More than one root found or noroots found");
    }

    int rootValue = (Integer) clonedValues.iterator().next();
    TreeNode root = new TreeNode(rootValue);

    HashMap valueNodeMap = new HashMap();
    // Put the root node into value map as it will not be present
    // in the list of children
    valueNodeMap.put(root.value, root);

    // Populate all children into valueNode map
    for (Integer child : children) {
      TreeNode valueNode = new TreeNode(child);
      valueNodeMap.put(child, valueNode);
    }

    // Now the map contains all nodes in the tree. Iterate through
    // all the children and
    // associate them with their parents
    for (Integer child : children) {
      TreeNode childNode = valueNodeMap.get(child);
      int parent = childParentMap.get(child);
      TreeNode parentNode = valueNodeMap.get(parent);
      parentNode.children.add(childNode);
    }

    // Traverse tree in level order to see the output. Pretty
    // printing the tree would be very
    // long to fit here.
    Queue q1 = new ArrayDeque();
    Queue q2 = new ArrayDeque();
    q1.add(root);
    Queue toEmpty = null;
    Queue toFill = null;
    while (true) {
      if (false == q1.isEmpty()) {
        toEmpty = q1;
        toFill = q2;
      } else if (false == q2.isEmpty()) {
        toEmpty = q2;
        toFill = q1;
      } else {
        break;
      }
      while (false == toEmpty.isEmpty()) {
        TreeNode node = toEmpty.poll();
        System.out.print(node.value + ", ");
        toFill.addAll(node.children);
      }
      System.out.println("");
    }
  }

}
