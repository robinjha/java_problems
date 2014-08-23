package com.java.collection.Stacks;

import java.util.LinkedList;
import java.util.Queue;


public class ImplementStackUsingQueues<T> {
	
	private Queue<T> q1 = new LinkedList<T>();
	private Queue<T> q2 = new LinkedList<T>();
	
	public void push(T node){
		q1.offer(node);
	}
	
	public T pop(){
		while(q1.size() > 1){
			q2.add(q1.poll());
		}
		
		T result = q1.poll();
		
		while(!q2.isEmpty()){
			q1.add(q2.poll());
		}
		return result;
	}
	
	public T peek(){
		if(!q1.isEmpty()){
			while(q1.size() > 1){
				q2.offer(q1.poll());
			}
			
			T result = q1.peek();
			q2.offer(result);
			
			while(!q2.isEmpty()){
				q1.offer(q2.poll());
			}
			return result;
			
		}else{
			return null;
		}
	}
	

	public static void main(String[] args) {
		
		ImplementStackUsingQueues<String> stack = new ImplementStackUsingQueues<String>();
		stack.push("One");
		stack.push("Two");
		stack.push("Three");
		stack.push("Four");
		
		System.out.println("~~~~PEEK~~~~~~");
		System.out.println(stack.peek());
		
		System.out.println("~~~~POP~~~~~~");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		
	}

}
