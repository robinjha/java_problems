package com.java.collection;


public  class Node{
	private Node next;
	private int data;
	private Node random;
	
	public Node(int n){
		data = n;
	}
	public Node(int d, Node n){
		next = n;
		data = d;
	}
	
	public Node(int d, Node n, Node r){
		next = n;
		data = d;
		random = r;
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
	public Node getRandom() {
		return random;
	}
	public void setRandom(Node random) {
		this.random = random;
	}
}