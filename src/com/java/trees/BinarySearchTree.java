package com.java.trees;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<T extends java.lang.Comparable<T>> {
	public static int count = 0;
	public static int count1 = 0;
	/**
	 * the node class
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
			if (visiting.empty()) {	// at beginning of iterator
				// find the leftmost node, pushing all the intermediate nodes
				// onto the visiting stack
				pushLeftMostChildNodeRecord(root);
			} // the node on top of the visiting stack is the next one to be
			// visited, unless it has a right subtree
			if ((visiting.peek().right == null) || // no right subtree, or
					(visitingRightChild.peek())) { // right subtree already visited
				// already visited right child, time to visit the node on top
				T result = visiting.pop().item;
				visitingRightChild.pop();
				if (visiting.empty()) {
					root = null;
				}
				return result;
			} else { // now visit this node's right subtree
				Boolean result = visitingRightChild.pop();
				visitingRightChild.push(true);
				// now push everything down to the leftmost node
				// in the right subtree
				BinaryNode<T> right = visiting.peek().right;
//				assert(right != null);
				pushLeftMostChildNodeRecord(right);
				// use recursive call to visit that node
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
			if(visiting.empty()){
				pushLeftMostChildNodeRecord(root);
			}
			BinaryNode<T> node = visiting.pop();
			T result = node.item;

			if(node.right != null){
				BinaryNode<T> right = node.right;
				pushLeftMostChildNodeRecord(right);
			}
			if(visiting.empty()){
				root = null;
			}
			return result;
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

	public BinaryNode<T> root = null;

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

	protected T getLeftmost(BinaryNode<T> node) {
		//	BinaryNode<T> right = node.right;
		if(node.left == null){
			return node.item;
		}else{
			return getLeftmost(node.left);
		}
	}
	
	public int height()
	   {
	      return height(root);
	   }
	   private int height(BinaryNode<T> p)
	   {
	      if(p == null) return -1;
	      else
	      return 1 + Math.max( height(p.left), height(p.right));
	   }

	   public int countLeaves()
	   {
	      return countLeaves(root);
	   }
	   private int countLeaves(BinaryNode<T> p)
	   {
	      if(p == null) return 0;
	      else
	      if(p.left == null && p.right == null) return 1;
	      else
	      return countLeaves(p.left) + countLeaves(p.right);
	   }
	
	//The width of a binary tree is the maximum number of elements on one level of the tree.
	   public int width()
	   {
	      int max = 0;
	      for(int k = 0; k <= height(); k++)
	      {
	         int tmp = width(root, k);
	         if(tmp > max) max = tmp;
	      }
	      return max;
	   }
	   //rerturns the number of node on a given level
	   public int width(BinaryNode<T> p, int depth)
	   {
	      if(p==null) return 0;
	      else
	      if(depth == 0) return 1;
	      else
	      return width(p.left, depth-1) + width(p.right, depth-1);
	   }

	   //The diameter of a tree is the number of nodes
	   //on the longest path between two leaves in the tree.
	   public int diameter()
	   {
	      return diameter(root);
	   }
	   
	   private int diameter(BinaryNode<T> p)
	   {
	      if(p==null) return 0;

	      //the path goes through the root
	      int len1 = height(p.left) + height(p.right) +3;

	      //the path does not pass the root
	      int len2 = Math.max(diameter(p.left), diameter(p.right));

	      return Math.max(len1, len2);
	   }
	   
	   /**
	    * traverse right, center and left. Inorder in opposite direction
	    * @return
	    */
	   public void findKthLargest(BinaryNode<T> root, int k){
		   if(root != null){
			   findKthLargest(root.right,k);
			   count++;
			   if(count == k){
				   System.out.println(k +" largest : "+root.item);
				   //return root.item;
			   }
			   findKthLargest(root.left, k);
		   }
		   //return null;
	   }

	   /**
	    * traverse left, center and right. Inorder traversal
	    * @return
	    */
	   public void findKthSmallest(BinaryNode<T> root, int k){
		  
		   if(root != null){
			   findKthSmallest(root.left,k);
			   count1++;
			   if(count1 == k){
				   System.out.println(k +" smallest : "+root.item);
			   }
			   findKthSmallest(root.right, k);
		   }
	   }

	public Iterator<T> iterator() {
		return new TreeIterator(root);
	}

	public Iterator<T> preIterator() {
		return new TreeIterator(root, true);
	}

	public Iterator<T> postIterator() {
		return new TreeIterator(root, false);
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
	 * main method to test iteration for different traversals
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

		System.out.println("The leftmost node is :" + bst.getLeftmost(bst.root));
		System.out.println("The rightmost node is :" + bst.getRightmost(bst.root));

		Iterator<String> it = bst.preIterator();
		System.out.print("pre-order: ");
		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println("");

		it = bst.postIterator();
		System.out.print("post-order: ");
		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println("");

		it = bst.iterator();
		System.out.print("in-order: ");
		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println("");
		
		//testing diameter
	      System.out.println("diameter = " + bst.diameter());
	      //testing width
	      System.out.println("width = " + bst.width());
	      
	      System.out.println("Height =" + bst.height());

	      bst.findKthLargest(bst.root, 4);
	 
	      bst.findKthSmallest(bst.root, 3);
	}


}
