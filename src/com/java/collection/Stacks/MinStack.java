package com.java.collection.Stacks;

import java.util.Stack;

public class MinStack extends Stack<Integer> {
	Stack<Integer> minStack;
	
	
	public MinStack(){
		minStack = new Stack<Integer>();
	}
	
	public Integer pop(){
		int value = super.pop();
		if(value == min()){
			minStack.pop();
		}
		return value;
	}
	
	public void push(int value){
		if(value <= min())
			minStack.push(value);
		super.push(value);
	}
	
	public int min(){
		
		return capacityIncrement;
		
	}
	

	public static void main(String[] args) {
		

	}

}
