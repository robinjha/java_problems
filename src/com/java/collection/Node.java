package com.java.collection;


public  class Node{
	private Node next;
	private int data;
	
	public Node(int n){
		data = n;
	}
	public Node(int d, Node n){
		next = n;
		data = d;
	}
	
	public int getData(){
		return data;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setData(int N){
		data = N;
	}
	
	public void setNext(Node n){
		next = n;
	}
}