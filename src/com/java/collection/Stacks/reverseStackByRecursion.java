package com.java.collection.Stacks;
import java.util.Stack;


public class reverseStackByRecursion <T>{

	/**
	 * @param args
	 * @return 
	 */
	public T reverseStack(Stack<T> stk){
		T a = stk.pop();
		if(stk.isEmpty()){
			return a;
		}
		else{
			reverseStack(stk);
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
