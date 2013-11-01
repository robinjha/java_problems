package com.java.collection;


public class AddTwoNumbersInLL {
	
	/**
	 * this solution works if the LL are the same length
	 * @param n1
	 * @param n2
	 * @return
	 */
	public Node addTwoValuesinLL(Node n1, Node n2){
		if(n1 == null)return n2;
		if(n2 == null)return n1;
		Node newHead = null;
		int carry = 0, val = 0, nodeVal = 0;
		
		while(n1 != null && n2 != null){
			val = n1.getData() + n2.getData()+carry;
			if(val > 10)
				carry = 1;
			else
				carry = 0;
			
			nodeVal = val % 10;
			newHead = new Node(nodeVal, newHead);
			n1 = n1.getNext();
			n2 = n2.getNext();
		}
		if(carry != 0){
			newHead = new Node(carry, newHead);
		}
		return newHead;
	}
	
	/**
	 * recursive solution
	 * @param args
	 */
	public Node addTwoValuesinLLRecursively(Node n1, Node n2){
		return null;
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
		Node e = new Node(8);
		d.setNext(e);
		
		AddTwoNumbersInLL blah = new AddTwoNumbersInLL();
		RemoveDuplicatesFromList test = new RemoveDuplicatesFromList();
		test.printNodes(blah.addTwoValuesinLL(list1, list2));

	}

}
