package com.java.trees;

public class IsSubtreeOptimized {
	
	public static boolean containsTree(BinaryNode<Integer> n1, BinaryNode<Integer> n2){
		if(n2 == null)
			return true; // if the tree is empty then it is always a subtree
		
		return isSubTree(n1, n2);
	}
	
	public static boolean isSubTree(BinaryNode<Integer> n1, BinaryNode<Integer> n2){
		if(n1 == null)
			return false;
		
		if(n1.getItem() == n2.getItem()){
			if(match(n1,n2)){
				return true;
			}
		}
		return (isSubTree(n1.getLeft(), n2) || isSubTree(n1.getRight(), n2));
	}
	
	public static boolean match(BinaryNode<Integer> n1, BinaryNode<Integer> n2){
		if(n1 == null && n2 == null)
			return true;
		
		if(n1 == null || n2 == null){
			return false;
		}
		
		if(n1.getItem() != n2.getItem())
			return false;
		return match(n1.getLeft(), n2.getLeft()) && match(n1.getRight(), n2.getRight());
	}

	public static void main(String[] args) {
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
		
		System.out.println(containsTree(root, root1));
	}

}
