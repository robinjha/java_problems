/**
 * O(n+m) memory where n is the number of nodes in the larger tree and m is the number of nodes in the smaller tree
 * O(n+m) time 
 */

package com.java.trees;

import java.util.ArrayList;
import java.util.List;

public class IsSubtree {
	
	//private static ArrayList<Integer> preOrderArr;
	public static boolean isSubTree(List<Integer> list1, List<Integer> list2){
		boolean value = false;
		
		if(list1.containsAll(list2))
		{
			value = true;
		}else{
			value = false;
		}
		
		return value;
	}
	
	public static List<Integer> preOrder(BinaryNode<Integer> node){
		if(node == null)
			return new ArrayList<Integer>();
			
		List<Integer> preOrderArr = new ArrayList<Integer>();
		preOrderArr.add(node.getItem());
		preOrderArr.addAll(preOrder(node.getLeft()));
		preOrderArr.addAll(preOrder(node.getRight()));
		return preOrderArr;
	}
	
	public static void main(String[] args){
		BinaryNode<Integer> root = new BinaryNode<Integer>(5);
		root.setLeft(new BinaryNode<Integer>(3));
		root.setRight(new BinaryNode<Integer>(1));
		root.getLeft().setLeft(new BinaryNode<Integer>(4));
		root.getLeft().setRight(new BinaryNode<Integer>(8));
		root.getRight().setLeft(new BinaryNode<Integer>(2));
		root.getRight().setRight(new BinaryNode<Integer>(6));
		
		BinaryNode<Integer> root1 = new BinaryNode<Integer>(1);
		root1.setLeft(new BinaryNode<Integer>(2));
		root1.setRight(new BinaryNode<Integer>(6));
		
		System.out.println(preOrder(root).toString());
		System.out.println(preOrder(root1).toString());
		
		System.out.println("Is subtree: " + isSubTree(preOrder(root), preOrder(root1)));
		
	}

}
