package com.java.collection;

public class AddTwoNumbersInLL {
	
	public Node addTwoValuesinLL(Node n1, Node n2){
		if(n1 == null)return n2;
		if(n2 == null)return n1;
		Node newHead = null;
		int carry = 0, val = 0;
		
		while(n1 != null && n2 != null && carry != 0){
			val = n1.getData() + n2.getData()+carry;
				carry = val % 10;
			
			val = val - carry;
			newHead = new Node(val, newHead);
			n1 = n1.getNext();
			n2 = n2.getNext();
		}
		return newHead;
	}

	public static void main(String[] args) {
		Node list1 = new Node(7);
		Node a = new Node(1);
		list1.setNext(a);
		Node b = new Node(6);
		a.setNext(b);
		
		Node list2 = new Node(5);
		Node d = new Node(9);
		list2.setNext(d);
		Node e = new Node(2);
		d.setNext(e);
		
		AddTwoNumbersInLL blah = new AddTwoNumbersInLL();
		RemoveDuplicatesFromList test = new RemoveDuplicatesFromList();
		test.printNodes(blah.addTwoValuesinLL(list1, list2));

	}

}
