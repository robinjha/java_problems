package com.java.collection;

public class FindNodeInCircularList {
	
	public Node curroptNode(Node head){
		Node slowRunner = head;
		Node fastRunner = head;
		
		while(fastRunner != null && fastRunner.getNext() != null){
			slowRunner = slowRunner.getNext();
			fastRunner = fastRunner.getNext().getNext();
			if(slowRunner == fastRunner){
				System.out.println("There is a loop!!");
				break;
			}
		}
		
		if(fastRunner == null || fastRunner.getNext() == null){
			System.out.println("There is no loop!!");
			return null;
		}
		
		slowRunner = head;
		while(slowRunner != fastRunner){
			slowRunner = slowRunner.getNext();
			fastRunner = fastRunner.getNext();
		}
		return fastRunner;
	}
	
	public static void main(String[] args){
		
		Node list1 = new Node(1);
		Node a = new Node(2);
		list1.setNext(a);
		Node b = new Node(3);
		a.setNext(b);
		Node d = new Node(4);
		b.setNext(d);
		Node e = new Node(5);
		d.setNext(e);
		Node f = new Node(3);
		e.setNext(b);
		
		FindNodeInCircularList blah = new FindNodeInCircularList();
		RemoveDuplicatesFromList test = new RemoveDuplicatesFromList();
		System.out.println(blah.curroptNode(list1).getData());
	}

}
