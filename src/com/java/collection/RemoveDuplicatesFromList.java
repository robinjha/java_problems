/**
 * removes duplicates from an unsorted linked list
 */

package com.java.collection;



public class RemoveDuplicatesFromList {
	
	public void deleteDuplicates(Node n1){
		Node head = n1;
		Node tmp = head;
		Node other = n1.getNext();
		
		while(tmp.getNext() != null){
			while(other.getNext() != null){
				if(tmp.getData() != other.getData()){
					other = other.getNext();
				}else{
					tmp.setNext(other.getNext());
				}
			}
			tmp = tmp.getNext();
		}
	}
	
	
	
	public static void main(String[] args) {
		Node list1 = new Node(1);
		Node a = new Node(2);
		list1.setNext(a);
		Node b = new Node(8);
		a.setNext(b);
		Node c = new Node(9);
		b.setNext(c);
		Node d = new Node(8);
		c.setNext(d);
		
		RemoveDuplicatesFromList test = new RemoveDuplicatesFromList();
		System.out.println("-----------------DELETING DUPLICATES---------------");
		test.deleteDuplicates(list1);
		test.printNodes(list1);
		
	}
	
	public void printNodes(Node head) {
		System.out.println();
		while(head != null){
			System.out.println(head.getData() + " ");
			head = head.getNext();
		}
		
	}

}
