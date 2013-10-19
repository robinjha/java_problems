package com.java.collection;

public class PartitionLinkedList {
	
	public Node partitionLinkedList(Node head, int val){
		Node beforeValHead = null;
		Node afterValHead = null;
		
		while(head != null){
			Node next = head.getNext();
			if(head.getData() <= val){
				head.setNext(beforeValHead);
				beforeValHead = head;
			}else{
				head.setNext(afterValHead);	
				afterValHead = head;
			}
			head = next;
		}
		Node n1 = beforeValHead;
		while(beforeValHead.getNext() != null){
			beforeValHead = beforeValHead.getNext();
		}
		beforeValHead.setNext(afterValHead);
		return n1;
	}

	public static void main(String[] args) {
		Node list1 = new Node(1);
		Node a = new Node(2);
		list1.setNext(a);
		Node b = new Node(8);
		a.setNext(b);
		Node c = new Node(3);
		b.setNext(c);
		Node d = new Node(9);
		c.setNext(d);
		Node e = new Node(7);
		d.setNext(e);
		
		PartitionLinkedList pLL = new PartitionLinkedList();
		RemoveDuplicatesFromList test = new RemoveDuplicatesFromList();
		test.printNodes(pLL.partitionLinkedList(list1, 3));

	}

}
