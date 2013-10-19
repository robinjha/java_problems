package com.java.collection;

public class KthElementFromLastInLL{
	
	public Node kthElementFromEnd(int k, Node head){
		int count = 0;
		int index = 0;
		if(head == null) return null;
		while(head.getNext() != null){
			head = head.getNext();
			count++;
		}
		System.out.println("Count :" + count);
		index = count - k;
		System.out.println("Kth element from the end is at index :" + (count - k));
		
		
		
		return null;
	}
	
	public static void main(String[] args){
			Node list1 = new Node(1);
			Node a = new Node(2);
			list1.setNext(a);
			Node b = new Node(8);
			a.setNext(b);
			Node c = new Node(9);
			b.setNext(c);
			Node d = new Node(8);
			c.setNext(d);
			Node e = new Node(8);
			d.setNext(e);
			
			KthElementFromLastInLL test = new KthElementFromLastInLL();
			test.kthElementFromEnd(3, list1);
		
	}

}
