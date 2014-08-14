package com.java.collection;

public class ThreadSafeCircularQueue<T> {
	
	
	private T[] elements;
	private int capacity;
	private int count;
	private int front = 0;
	
	
	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ThreadSafeCircularQueue(int capacity) {
		count = 0;
		this.capacity = capacity;
		this.elements = (T[]) new Object[capacity];
	}

	public boolean isFull(){
		if(getCount() == capacity){
			return true;
		}
		return false;
	}
	
	
	public synchronized void enqueue(T item){
		if(capacity == elements.length){
			
		}
	}

	
	public synchronized T dequeue(){
		
		
		return null;
	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
