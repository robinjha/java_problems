package com.java.trees;


/**
 * A binary search tree (BST) is a node based binary tree data structure which has the following properties.
 * The left subtree of a node contains only nodes with keys less than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * @author robin
 *
 */

public class IsBST {
	public static int min = Integer.MIN_VALUE;
	/**
	Strategy: 
	1) Do In-Order Traversal of the given tree.
	3) We keep track of previously visited node. If the value of the currently visited node is less than the previous value,
	 then tree is not BST. 

	Time Complexity: O(n)
	*/
	public static boolean bstCheck(BinaryNode<Integer> root){
		if(root == null) return true;
		
		if(!bstCheck(root.getLeft())){
			return false;
		}
		
		if(root.getItem() < min){
			return false;
		}
		min = root.getItem();
		
		if(!bstCheck(root.getRight())){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		BinaryNode<Integer> root = null;
		BalancedMinimalBinarySearchTree b = new BalancedMinimalBinarySearchTree();
		root = b.createBalancedMinimalBST(arr,0, arr.length -1 );
		System.out.println("Is Balanced : "+bstCheck(root));
	}
}
