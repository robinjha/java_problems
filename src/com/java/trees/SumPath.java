/**
 * prints out the nodes whose sum equals a given value.
 * Run time : O(n log(n))
 */

package com.java.trees;

public class SumPath {
	
	public static void findSumPath(BinaryNode<Integer> node, int sum, int[] path, int level){
		if(node == null)
			return;
		
		//System.out.println("Point 1");
		path[level] = node.getItem();
		int value = 0;
		for(int i = level; i >= 0; i--){
			value+=path[i];
			if(value == sum){
				//System.out.println("Point 2");
				printPath(path,i, level);
			}
		}
		//System.out.println("Point 3");
		findSumPath(node.getLeft(), sum, path , level+1);
		findSumPath(node.getRight(), sum, path, level+1);
		
	}
	
	public static void printPath(int[] path, int start, int end) {
		for(int j = start; j <= end; j++){
			System.out.print(path[j] + " ");
		}
		
		System.out.println();
	}

	public static void findSum(BinaryNode<Integer> node, int sum){
		int level = level(node);
		int[] path = new int[level];
		findSumPath(node, sum, path, 0);
	}
	
	public static int level(BinaryNode<Integer> node){
		if(node == null)
			return 0;
		else
			return 1+Math.max(level(node.getLeft()), level(node.getRight()));
	}
	

	public static void main(String[] args) {
		
		BinaryNode<Integer> root = new BinaryNode<Integer>(5);
		root.setLeft(new BinaryNode<Integer>(3));
		root.setRight(new BinaryNode<Integer>(1));
		root.getLeft().setLeft(new BinaryNode<Integer>(4));
		root.getLeft().setRight(new BinaryNode<Integer>(8));
		root.getRight().setLeft(new BinaryNode<Integer>(2));
		root.getRight().setRight(new BinaryNode<Integer>(6));
		
		System.out.println("Possible Paths are: ");
		findSum(root, 8);
		

	}

}
