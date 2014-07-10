package com.java.collection;

public class ReverseLinkedList {
	
	public static Node reverse(Node head){
		if(head == null) return null;
		if(head.getNext() == null) return head;
		 // reverse the sub-list leaving the head node.
		Node newNode = reverse(head.getNext());
		// head.next still points to the last element of reversed sub-list.
		  // so move the head to end.
		head.getNext().setNext(head);
		// point last node to nil, (get rid of cycles)
		head.setNext(null);
		return newNode;
	}
	
	public static void reverseIter(Node head){
		if(head == null) return;
		//if(head.getNext() == null) return head;
		
		Node prev = null;
		Node next = null;
		
		while(true){
			next = head.getNext();
			head.setNext(prev);
			prev = head;
			if(next == null) return;
			head = next;
		}
	}
	

	public static void printLinkedList(Node head)
	  {
	   while (head != null)
	   {
	    System.out.print(head.getData() + "->");
	    head = head.getNext();
	   }
	   System.out.println();
	  }
	
	public static void main(String[] args) {
		Node list1 = new Node(7);
		Node a = new Node(1);
		list1.setNext(a);
		Node b = new Node(6);
		a.setNext(b);
		Node d = new Node(1);
		b.setNext(d);
		Node e = new Node(8);
		d.setNext(e);
		
		printLinkedList(reverse(list1));
		//reverseIter(list1);
		//printLinkedList(list1);
	}

}
