package com.java.collection;

import java.util.Stack;

public class PalindromeLL {

	public boolean isPalindrome(Node head){
		boolean palindrome = false;
		Node slowRunner = head;
		Node fastRunner = head;
		
		Stack<Integer> s = new Stack<Integer>();
		while(fastRunner != null && fastRunner.getNext() != null){
			s.push(slowRunner.getData());
			slowRunner = slowRunner.getNext();
			fastRunner = fastRunner.getNext().getNext();
		}
		
		if(fastRunner != null){ // this takes care of the odd number of elements in the LL. Sets the node to the next one
			slowRunner = slowRunner.getNext();
		}
		
		while(slowRunner != null){
			int val = s.pop().intValue();
			System.out.println("Values:" + slowRunner.getData() + " " + val);
			if(val != slowRunner.getData()){
				palindrome = false;
				return palindrome;
			}
			slowRunner = slowRunner.getNext();
		}
		palindrome = true;
		return palindrome;
	}
	public static void main(String[] args){
		Node list1 = new Node(7);
		Node a = new Node(1);
		list1.setNext(a);
		Node b = new Node(6);
		a.setNext(b);
		Node d = new Node(1);
		b.setNext(d);
		Node e = new Node(7);
		d.setNext(e);
		
		PalindromeLL test = new PalindromeLL();
		System.out.println("Is the LL palindrome :" + test.isPalindrome(list1));
	}
}
