/**
 * 
 * Given an unsorted list with each node having a random pointer to another node,
 *  sort the list such that each node points to the next node in the list (n1->n2->n3).
 */

package com.java.sort;

import java.util.List;

class Node{
	
	int data;
	Node next;
	public Node(int data) {
		super();
		this.data = data;
		this.next = null;
	}
	
}

public class SortLinkedList {
	
	
	
	
	public static Node mergeSortList(Node head){
		
		if(head == null || head.next == null){
			return head;
		}
		
		//get count of the number of elements
		int count = 0;
		Node start = head;
		while(start != null){
			count++;
			start = start.next;
		}
		System.out.println("Count is :" + count);
		
		int middle = count / 2;
		 
		Node l = head, r = null;
		Node p2 = head;
		int countHalf = 0;
		while(p2 != null){
			countHalf++;
			Node next = p2.next;
			
			if(countHalf == middle){
				p2.next = null;
				r = next;
			}
			p2 = next;
		}
		
		Node part1 = mergeSortList(l);
		Node part2 = mergeSortList(r);
		
		Node merged = merge(part1,part2);
		
		return merged;
	}
	
	

	public static Node merge(Node l, Node r) {
		Node p1 = l;
		Node p2 = r;
		
		Node tmp = new Node(1000);
		Node var = tmp;
		
		while(p1 != null || p2 != null){
			
			if(p1 == null){
				 var.next = new Node(p2.data);
				 p2 = p2.next;
				 var = var.next;
			}else if(p2 == null){
				var.next = new Node(p1.data);
				 p1 = p1.next;
				 var = var.next;
			}else{
				if(p1.data < p2.data){
					var.next = new Node(p1.data);
					p1 = p1.next;
					var = var.next;
				}else if(p1.data > p2.data){
					var.next = new Node(p2.data);
					p2 = p2.next;
					var = var.next;
				}else{
					var.next = new Node(p1.data);
					var.next.next = new Node(p2.data);
					p1 = p1.next;
					p2 = p2.next;
					var = var.next.next;
				}
				
			}
			
			
		}
		return tmp.next;
	}

	public static void printList(Node x) {
		if(x != null){
			System.out.print(x.data + " ");
			while (x.next != null) {
				System.out.print(x.next.data+ " ");
				x = x.next;
			}
			System.out.println();
		}
 
	}

	public static void main(String[] args) {
		Node head = new Node(2);
		Node first = new Node(3);
		head.next = first;
		Node second = new Node(4);
		first.next = second;
		Node third = new Node(3);
		second.next = third;
		Node fourth = new Node(4);
		third.next = fourth;
		Node fifth = new Node(5);
		fourth.next = fifth;
		
		System.out.println("Sort Linked List");
		head = mergeSortList(head);
		printList(head);
		//System.out.println("Sort Linked List" + mergeSortList(head).data);
	}

}
