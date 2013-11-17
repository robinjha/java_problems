package com.java.trees;



public class BinaryNode<T>{
	private T item;
	private BinaryNode<T> left;
	private BinaryNode<T> right;

	/**
	 * contructor to build a tree
	 */
	public BinaryNode(T value){
		setItem(value);
		setLeft(null);
		setRight(null);
	}

	/**
	 * contructor to build node with specified subtrees/nodes
	 */
	public BinaryNode(T value, BinaryNode<T> l, BinaryNode<T> r){
		setItem(value);
		setLeft(l);
		setRight(r);
	}

	public BinaryNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}

	public BinaryNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	@Override
	public String toString() {
//		return "BinaryNode [item=" + item + ", left=" + left + ", right="
//				+ right + "]";
		return "BinaryNode ["+ item+"]";
	}
	
	
	
	
}