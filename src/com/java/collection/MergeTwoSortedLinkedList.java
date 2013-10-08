/**
 * Given an integer linked list of which both first half and second half are sorted 
 * independently. Write a function to merge the two parts to create one single sorted 
 * linked list in place [do not use any extra space]. 
 * 
 * @author : robin
 * date: 09/30/2013
 */

package com.java.collection;


public class MergeTwoSortedLinkedList<T> {
	
	private static class Node{
		private Node next;
		private int data;
		
		public Node(int n){
			data = n;
		}
		public Node(int d, Node n){
			next = n;
			data = d;
		}
		
		public int getData(){
			return data;
		}
		
		public Node getNext(){
			return next;
		}
		
		public void setData(int N){
			data = N;
		}
		
		public void setNext(Node n){
			next = n;
		}
	}

	/**
	 * this function merges the two linked list iteratively
	 * @param - first node of 1st list
	 * @param - first node of 2nd list
	 * returns the first node of the merged list
	 */
	public Node MergeLists(Node list1, Node list2) {
		Node head, other, merged;
		if(list1 == null)return list2;
		if(list2 == null)return list1;
		
		
		merged = head = (list1.data <= list2.data) ? list1: list2;
		other = (list1.data > list2.data) ? list1: list2;
		
		while(merged.next != null){
			if(other.data > merged.data && other.data < merged.next.data){
				Node temp = merged.next;
				merged.next = other;
				other = temp;
				System.out.println("Node added {i}:" + other.data);
			}
			merged = merged.next;
			System.out.println("Node :" + merged.data);
		}
		return head;
	}
	
	
	/**
	 *  this function merges the two linked list recursively
	 * @param list1
	 * @param list2
	 * @return the pointer to the head of the merged list
	 */
	public Node MergeListsRecursively(Node list1, Node list2){
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		
		if(list1.data < list2.data){
			list1.next= MergeListsRecursively(list1.next, list2);
			return list1;
		}else{
			list2.next= MergeListsRecursively(list2.next, list1);
			return list2;
		}
	}
	
	public static void main(String[] args) {
		MergeTwoSortedLinkedList<Integer> m = new MergeTwoSortedLinkedList<Integer>();
		Node list1 = new Node(1);
		Node a = new Node(2);
		list1.next = a;
		Node b = new Node(8);
		a.next = b;
		Node c = new Node(10);
		b.next = c;
		Node d = new Node(11);
		c.next = d;
		Node list2 = new Node(1);
		Node e = new Node(3);
		list2.next = e;
		Node f = new Node(5);
		e.next = f;
		Node g = new Node(18);
		f.next = g;
		System.out.println("----------RECURSIVE----------------");
		Node merged = m.MergeListsRecursively(list1, list2);
		m.printNodes(merged);
		System.out.println("----------ITERATIVE----------------");
		Node mergedIter = m.MergeLists(list1, list2);
		m.printNodes(mergedIter);

	}

	public void printNodes(Node head) {
		System.out.println();
		while(head != null){
			System.out.println(head.data + " ");
			head = head.next;
		}
		
	}

}


