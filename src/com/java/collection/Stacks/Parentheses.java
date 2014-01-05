package com.java.collection.Stacks;

import java.util.Stack;

public class Parentheses {
	
	private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

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
    
	public static void main(String[] args){
		System.out.println("Is it balanced: " +isBalanced("[()]{}{[()()]()}"));
		System.out.println("Is it balanced: " +isBalanced("[()]{}{[(()]()}"));
	}
}
