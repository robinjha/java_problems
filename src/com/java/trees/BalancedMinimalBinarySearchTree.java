package com.java.trees;



public class BalancedMinimalBinarySearchTree {
	
	public static BinaryNode<Integer> createBalancedMinimalBST(int[] arr, int first, int last){
		if(first > last){
			return null;
		}
		int mid = (first+last)/2;
		BinaryNode<Integer> root = new BinaryNode<Integer>(arr[mid], createBalancedMinimalBST(arr, first, mid-1),createBalancedMinimalBST(arr, mid+1, last) );
		return root;
	}
	
	public static void traverse (BinaryNode<Integer> root){ // Each child of a tree is a root of its subtree.
	    if (root.getLeft() != null){
	        traverse (root.getLeft());
	    }
	    System.out.println(root.getItem());
	    
	    if (root.getRight() != null){
	        traverse (root.getRight());
	    }
	}
	
	public static void main(String[] args){
		
		int[] arr = {1,2,3,4,5,6,7,8,9};
		traverse(createBalancedMinimalBST(arr,0, arr.length -1 ));
		
		
	}

}
