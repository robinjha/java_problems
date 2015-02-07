package com.java.collection.Stacks;

import java.util.Stack;

public class Parentheses {
	
	private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

    
    //this is based on a stack solution using an auxiliary 
    public static boolean isBalanced(String str){
    	Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == LEFT_PAREN) stack.push(str.charAt(i));
			if(str.charAt(i) == LEFT_BRACE) stack.push(str.charAt(i));
			if(str.charAt(i) == LEFT_BRACKET) stack.push(str.charAt(i));
			
			if(str.charAt(i) == RIGHT_PAREN){
				if(stack.isEmpty()) return false;
				if(stack.pop() != LEFT_PAREN) return false;
			}
			
			if(str.charAt(i) == RIGHT_BRACE){
				if(stack.isEmpty()) return false;
				if(stack.pop() != LEFT_BRACE) return false;
			}
			
			if(str.charAt(i) == RIGHT_BRACKET){
				if(stack.isEmpty()) return false;
				if(stack.pop() != LEFT_BRACKET) return false; 
		    }
		}
		return stack.isEmpty();
    }
    
    //another solution without using stack
    // time complexity O(n)
    public static boolean isBalancedWithoutStack(String str){
    	int balance = 0;
    	for(int i = 0; i < str.length(); i++){
    		if(str.charAt(i) == LEFT_PAREN){
    			balance+=1;
    		}else if(str.charAt(i) == RIGHT_PAREN){
    			balance-=1;
    		}
    		
    		if(balance < 0) return false;
    	}
    	return balance == 0;
    }
    
	public static void main(String[] args){
		System.out.println("Is it balanced: " +isBalanced("[()]{}{[()()]()}"));
		System.out.println("Is it balanced: " +isBalanced("[()]{}{[(()]()}"));
		System.out.println(isBalancedWithoutStack("()")); //true
		System.out.println(isBalancedWithoutStack("(")); //false
		System.out.println(isBalancedWithoutStack(")("));//false
	}
}
