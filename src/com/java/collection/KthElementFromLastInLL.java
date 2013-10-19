package com.java.collection;

public class KthElementFromLastInLL{
	
	/**
	 * finds the kth to last element iteratively.
	 * @param k
	 * @param head
	 * @return - 
	 */
	public Node kthElementFromEnd(int k, Node head){
		int count = 0;
		int index = 0;
		int val = 1;
		if(k <= 0) return null;
		Node tmp = head;
		if(head == null) return null;
		while(head.getNext() != null){
			head = head.getNext();
			count++;
		}
		head = tmp;
		System.out.println("Count :" + count);
		index = count - k;
		System.out.println("Kth element from the end is at index :" + (count - k));
		while(head != null){
			if(val == index){
				System.out.println("Kth Element value is :"+ head.getData());
				return head;
			}else{
				head = head.getNext();
				val++;
			}
		}
		
		return head;
	}
	
	public int kthToLastRecursively(int k, Node n1){
		if(n1 == null) return -1;
		int pos =	kthToLastRecursively(k, n1.getNext())+1;
		if(pos == k){
			System.out.println("Element is :" + n1.getData());
		}
		return pos;
		
	}
	
	public static void main(String[] args){
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
			
			KthElementFromLastInLL test = new KthElementFromLastInLL();
			//test.kthElementFromEnd(3, list1);
			test.kthToLastRecursively(3, list1);
		
	}

}
