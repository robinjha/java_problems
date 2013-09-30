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
		Node item;
		int data;
	}

	/**
	 * @param - first node of 1st list
	 * @param - first node of 2nd list
	 * returns the first node of the merged list
	 */
	public Node MergeLists(Node list1, Node list2) {
		Node head;
		if(list1 == null){
			return list2.item;
		}
		if(list2 == null){
			return list1.item;
		}
		if(list1.data < list2.data){
			head = list1;
		}
		else{
			head = list2;
		}
		return list1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList part1 = new LinkedList();
		

	}

}


