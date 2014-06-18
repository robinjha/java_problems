package com.java.collection;

import java.util.ArrayList;
import java.util.List;

import com.java.collection.Node;


public class SplitListIntoFrontAndBack {
	
	public static void splitList(List<Integer> origList){
	    List<Integer> firstHalf = new ArrayList<Integer>();
	    List<Integer> secondHalf = new ArrayList<Integer>();
	    
	    int mid = origList.size()/2;
	    
	    for(int i = 0; i < mid; i++){
	    	firstHalf.add(origList.get(i));
	    }
	    
	    for(int i = mid; i < origList.size(); i++){
	    	secondHalf.add(origList.get(i));
	    }
	    
	    System.out.println(firstHalf.toString());
	    System.out.println(secondHalf.toString());
	    
	}
	
	/**
	 * We use two pointers (we call it a slow pointer and a fast pointer). 
	 * The slow pointer advances one node at a time, while the fast pointer advances two nodes at a time.
	 * By the time the fast pointer reaches the end, the slow pointer would have reached the splitting point 
	 * (or near).
	 */
	public static Node[] frontBackSplit(Node head, Node front, Node back) {
		Node[] arr = new Node[2];
		if(head == null || head.getNext() == null) return null;// Handle empty  and one node lists
		Node frontLastNode = null;
		Node slow = head;
		Node fast = head;
		
		while(fast != null){
			frontLastNode = slow;
			slow = slow.getNext();
			if(fast.getNext() != null){
				fast = fast.getNext().getNext();
			}else{
				fast = null;
			}
		}
		frontLastNode.setNext(null); // ends the front sublist
		arr[0] = front = head;
		arr[1] = back = slow;
		return arr;
	}
	
	public static void printNodes(Node[] arr) {
		
		System.out.println();
		for(int i = 0; i < arr.length ; i++){
			System.out.println("Printing list " + i);
			while(arr[i] != null){
				System.out.println(arr[i].getData() + " ");
				arr[i]= arr[i].getNext();
			}
			
		}
		
	}

	public static void main(String[] args) {
		List<Integer> arrList = new ArrayList<Integer>();
		arrList.add(0);
		arrList.add(3);
		arrList.add(4);
		arrList.add(7);
		arrList.add(9);
		arrList.add(2);
		//splitList(arrList);
		
		Node list1 = new Node(2);
		Node a = new Node(3);
		list1.setNext(a);
		Node b = new Node(5);
		a.setNext(b);
		Node c = new Node(7);
		b.setNext(c);
		Node d = new Node(11);
		c.setNext(d);
		//Node e = new Node(7);
		//d.setNext(e);
		printNodes(frontBackSplit(list1, list1, d));
	}

}
