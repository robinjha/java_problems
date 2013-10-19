package com.java.collection;

public class DeleteNodeGivenNode {
	
	public boolean deleteNode(Node n1){
		if(n1 == null || n1.getNext() == null){
			return false;
		}else{
			n1.setData(n1.getNext().getData());
			n1.setNext(n1.getNext().getNext());
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node list1 = new Node(1);
		Node a = new Node(2);
		list1.setNext(a);
		Node b = new Node(8);
		a.setNext(b);
		Node c = new Node(9);
		b.setNext(c);
		Node d = new Node(8);
		c.setNext(d);
		
		DeleteNodeGivenNode dGN = new DeleteNodeGivenNode();
		dGN.deleteNode(a);
		RemoveDuplicatesFromList test = new RemoveDuplicatesFromList();
		test.printNodes(list1);

	}

}
