package com.java.trees;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<T extends java.lang.Comparable<T>> {
	
	/**
	 * A node in the tree
	 */
	private static class BinaryNode<T>{
		private T item;
		private BinaryNode<T> left;
		private BinaryNode<T> right;
		
		/**
		 * contructor to build a tree
		 */
		private BinaryNode(T value){
			item = value;
			left = null;
			right = null;
		}
		
		/**
		 * contructor to build node with specified subtrees/nodes
		 */
		private BinaryNode(T value, BinaryNode<T> l, BinaryNode<T> r){
			item = value;
			left = l;
			right = r;
		}
	}
	
	private class TreeIterator implements Iterator<T>{
		/*
		 * variable to keep track of the iterator.
		 */
		protected BinaryNode<T> root = null;
		protected Stack<BinaryNode<T>> visiting = new Stack<BinaryNode<T>>();
		protected Stack<Boolean> visitingRightChild = new Stack<Boolean>(); 
		
		boolean preorder = false;
		boolean inorder = true;
		boolean postorder = false;
		
		/*
		 * Inorder constructor
		 */
		public TreeIterator(BinaryNode<T> root){
			this.root = root;
			visiting = new Stack<BinaryNode<T>>();
			visitingRightChild = new Stack<Boolean>();
			preorder = false;
			inorder = true;
			postorder = false;
		}
		
		/*
		 * preorder constructor
		 */
		public TreeIterator(BinaryNode<T> root, boolean inPreOrder){
			this.root = root;
			visiting = new Stack<BinaryNode<T>>();
			visitingRightChild = new Stack<Boolean>();
			inorder = false;
			preorder = inPreOrder;
			postorder = !preorder;
		}

		public boolean hasNext() {
			return (root != null);
		}

		public T next() {
			// TODO Auto-generated method stub
			if(! hasNext()){
				throw new java.util.NoSuchElementException("no more elements");
			}
			if(preorder){
				return preorderNext();
			}
			else if(inorder){
				return inorderNext();
			}
			else if(postorder){
				return postorderNext();
			}
			else
				return null;
		}

		private T postorderNext() {
			if(visiting.empty()){
				pushLeftMostChildNodeRecord(root);
			}
			
			if(visiting.peek().right == null || visitingRightChild.peek()){
				T result = visiting.pop().item;
				visitingRightChild.pop();
				if(visiting.empty()){
					return null;
				}
				return result;
			}else{
				visitingRightChild.push(true);
				BinaryNode<T> right = visiting.peek().right;
				pushLeftMostChildNodeRecord(right);
				return postorderNext();
			}
		}

		private void pushLeftMostChildNodeRecord(BinaryNode<T> node) {
			if(node != null){
				visiting.push(node);
				visitingRightChild.push(false);
				pushLeftMostChildNodeRecord(node.left);
			}
			
		}

		private T inorderNext() {
			// TODO Auto-generated method stub
			return null;
		}

		private T preorderNext() {
			if(visiting.empty()){
				visiting.push(root);
			}
			BinaryNode<T> node = visiting.pop();
			T result = node.item;
			
			if(node.right != null){
				visiting.push(node.right);
			}
			if(node.left != null){
				visiting.push(node.left);
			}
			if(visiting.empty()){
				root = null;
			}
			return node.item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
		public String toString(BinaryNode<T> node){
			if(node == null){
				return "";
			}else{
				return node.toString() + "(" +toString(node.left) + ", " + toString(node.right) + ")";
			}
		}
		
		public String toString() {
			if (preorder) {
				return "pre: " + toString(root) + "\n" + visiting + "\n";
			}
			if (inorder) {
				return "in: " + toString(root) + "\n" + visiting + "\n";
			}
			if (postorder) {
				return "post: " + toString(root) + "\n" + visiting + "\n"
						+ visitingRightChild;
			}
			return "none of pre-order, in-order, or post-order are true";
		}

	}
	
	protected BinaryNode<T> root = null;
	
	public BinarySearchTree(){
		super();
	}
	
	public BinarySearchTree(T value){
		super();
		root = new BinaryNode<T>(value);
	}
	
	public BinarySearchTree(BinaryNode<T> newRoot){
		super();
		root = newRoot;
	}
	
	public void add(T value){
		root = add(value, root);
	}
	
	/**
	 * @param: value to be inserted
	 * @param: node that is the root of the subtree in which to insert 
	 */
	protected BinaryNode<T> add(T value, BinaryNode<T> node){
		if(node == null){
			return new BinaryNode<T>(value);
		}
		else{
			if(value.compareTo(node.item) < 0){
				node.left = add(value, node.left);
			}
			else{
				node.right = add(value, node.right);
			}
			return node;
		}
	}
	
	
	public void remove(T value){
		root = remove(value, root);
	}
	
	protected BinaryNode<T> remove(T value, BinaryNode<T> node){
		if(node == null){
			return null;
		}
		if(value.compareTo(node.item) == 0){
			if(node.right == null){
				return node.left;
			}else if(node.left == null){
				return node.right;
			}
			else{
				node.item = getRightmost(node.left);
				node.left = remove(node.item, node.left);
			}
		}else{
			if(value.compareTo(node.item) < 0 ){
				node.left = remove(value, node.left);
			}else{
				node.right = remove(value, node.right);
			}
		}
		return node;
	}
	
	protected T getRightmost(BinaryNode<T> node) {
	//	BinaryNode<T> right = node.right;
		if(node.right == null){
			return node.item;
		}else{
			return getRightmost(node.right);
		}
	}
	
	public Iterator<T> preIterator() {
		return new TreeIterator(root, true);
	    }
	
	public Iterator<T> postIterator() {
		return new TreeIterator(root, true);
	    }

	public String toString(){
		return toString(root);
	}
	
	protected String toString(BinaryNode<T> node){
		if(node == null){
			return "null";
		}
		return node.item.toString() + "(" + toString(node.left) + ", " +
    toString(node.right) + ")";
	}
	
	/**
	 * main method
	 */
	
	public static void main(String[] args){
		BinarySearchTree<String> bst = new BinarySearchTree<String>();
		bst.add("F");
		bst.add("B");
		bst.add("G");
		bst.add("A");
		bst.add("D");
		bst.add("I");
		bst.add("C");
		bst.add("E");
		bst.add("H");
		
		System.out.println(bst);
		
	//	bst.remove(7);
		System.out.println(bst);
		
		System.out.println("The rightmost node is :" + bst.getRightmost(bst.root));
		
		Iterator<String> it = bst.preIterator();
		System.out.print("pre-order: ");
		while (it.hasNext()) {
		    System.out.print(it.next() + ", ");
		}
		System.out.println("");
		
		Iterator<String> itPost = bst.postIterator();
		System.out.print("pre-order: ");
		while (itPost.hasNext()) {
		    System.out.print(itPost.next() + ", ");
		}
		System.out.println("");


	}
	

}
