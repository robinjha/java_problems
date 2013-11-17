package com.java.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class CreateLevelLinkedListFromBST {
	
	public static ArrayList<LinkedList<BinaryNode<Integer>>> levelLLFromBST(BinaryNode<Integer> root, ArrayList<LinkedList<BinaryNode<Integer>>> llLists, int depth){
		if(root == null) return null;
		
		LinkedList<BinaryNode<Integer>> l = null;
		if(llLists.size() == depth){
			l = new LinkedList<BinaryNode<Integer>>();
			llLists.add(l);
		}else{
			l = llLists.get(depth);
		}
		l.add(root);
		levelLLFromBST(root.getLeft(), llLists, depth+1);
		levelLLFromBST(root.getRight(), llLists, depth+1);
		return llLists;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<LinkedList<BinaryNode<Integer>>> lists = new ArrayList<LinkedList<BinaryNode<Integer>>>();
		BinaryNode<Integer> root = null;
		int[] arr = {1,2,3,4,5,6,7,8,9};
		BalancedMinimalBinarySearchTree b = new BalancedMinimalBinarySearchTree();
		root = b.createBalancedMinimalBST(arr,0, arr.length -1 );
		lists = levelLLFromBST(root,lists, 0);
		
		for(LinkedList<BinaryNode<Integer>> l : lists){
			System.out.println(Arrays.toString(l.toArray()));
		}

	}

}
