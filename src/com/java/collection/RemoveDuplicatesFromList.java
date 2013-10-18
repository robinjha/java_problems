/**
 * removes duplicates from an unsorted linked list
 */

package com.java.collection;

import java.util.HashMap;



public class RemoveDuplicatesFromList {
	
	//this is without an extra buffer
	//runs in O(1) space but O(N^2) time
	public void deleteDuplicates(Node n1){
		Node head = n1;
		Node prev = head;
		while(head != null){
			Node runner = head.getNext();
			while(runner != null){
				if(head.getData() != runner.getData()){
					prev = head.getNext();
				}
				else{
					prev.setNext(runner.getNext());
				}
				runner = runner.getNext();
			}
			head = head.getNext();
		}
	}
	
	/**
	 * 
	 * @param n1
	 * we just need to make a pass over the linked list once.
	 * this solution takes O(N) time, where N is the number of the elements in the LL
	 */
	
	public void deleteDuplicatesWithHashMap(Node n1){
		HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
		Node head = null;
		while(n1 != null){
			if(hm.containsKey(n1.getData())){
				head.setNext(n1.getNext());
				
			}else{
				hm.put(n1.getData(), true);
				head = n1;
			}
			n1 = n1.getNext();
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
		Node e = new Node(8);
		d.setNext(e);
		
		RemoveDuplicatesFromList test = new RemoveDuplicatesFromList();
		//System.out.println("-----------------DELETING DUPLICATES IN PLACE---------------");
		//test.deleteDuplicates(list1);
		System.out.println("-----------------DELETING DUPLICATES USING HASHMAP---------------");
		test.deleteDuplicatesWithHashMap(list1);
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
