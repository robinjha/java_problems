package com.java.collection;

import java.util.Stack;

public class reverseSeqUsingStack {

	public static void main(String[] args) {
		Stack<Integer> intStack = new Stack<Integer>();
		intStack.push(5);
		intStack.push(4);
		intStack.push(3);
		intStack.push(2);
		intStack.push(1);
		
		while(!intStack.isEmpty()){
			System.out.println(intStack.pop());
		}
	}

}
