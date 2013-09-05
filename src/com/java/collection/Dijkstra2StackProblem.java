/**
 * simple example of an interpreter
 * 
 * example stack client to evaluate parenthesized arithmetic expressions
 */

package com.java.collection;

import java.util.Stack;

public class Dijkstra2StackProblem {

	public static void main(String[] args) {
	
		Stack<Integer> intStack = new Stack<Integer>();
		Stack<Character> operStack = new Stack<Character>();
		
		String test = "(((3-2)*6)/6)";
		char[] charArr = test.toCharArray();
		
		for(int i = 0 ; i < charArr.length; i++){
			if(charArr[i] == '('){}
			else if(charArr[i] == '+'){ operStack.push(charArr[i]);}
			else if(charArr[i] == '-'){ operStack.push(charArr[i]);}
			else if(charArr[i] == '*'){ operStack.push(charArr[i]);}
			else if(charArr[i] == '/'){ operStack.push(charArr[i]);}
			else if(charArr[i] == ')'){
				char oper = operStack.pop();
				int firstVal = intStack.pop();
				if(oper == '+'){
					firstVal = intStack.pop() + firstVal;
				}else if(oper == '-'){
					firstVal = intStack.pop() - firstVal;
				}else if(oper == '*'){
					firstVal = intStack.pop() * firstVal;
				}else if(oper == '/'){
					firstVal = intStack.pop() / firstVal;
				}
				intStack.push(firstVal);
			}
			else{
				intStack.push(Character.getNumericValue(charArr[i])); // to get numeric value from a character
			}
		}
		System.out.println(intStack.pop());
	}

}
