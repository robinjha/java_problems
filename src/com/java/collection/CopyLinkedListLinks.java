package com.java.collection;
//import com.java.collection.Node;

/**
 * A link list contains following elements

struct node{
    int data;
    node* next;
    node* random;
}

Given head of such a linked list write a function who copies such a linked list 
and returns the head of the new list. So if in the original list first node points 
to fourth node in random the copy should have the same relation. The random pointer
 can point to any node including itself and more than two nodes can have random pointer
  to the same node.

Required time complexity O(n) and no extra space can be used (apart from the newly allocated 
memory which you will need to create the new list)

solution:
1. copy the 1st node and insert it between node 1 & node 2
3. Similarly, copy 2nd node and insert it between 2 & 3.. and so on
2) Copy the arbitrary link in this fashion
Originalnode->next->arbitrary = Originalnode->arbitrary->next;
and so on...for all nodes
3) Separate the original and copy linked lists.
 * @author robin
 *
 */

public class CopyLinkedListLinks {
	
	public static Node clone(Node head){
		if(head == null) return null;
		
		Node doubleHead = head;
		
		while(head != null){
			Node next = head.getNext();
			Node copy = new Node(head.getData(),head.getNext());
			head.setNext(copy);
			head = next;
		}
		
		Node originalRunner = doubleHead;
		
		while(originalRunner != null){
			originalRunner.getNext().setRandom(originalRunner.getRandom() == null ? null : originalRunner.getRandom().getNext());
			originalRunner = originalRunner.getNext().getNext();
		}
		
		Node copyHead = doubleHead.getNext();
		Node copyTail = null;
		while(doubleHead != null){
			Node copyNode = doubleHead.getNext();
			if(copyTail != null) copyTail.setNext(copyNode);
			copyTail = copyNode;
			doubleHead = doubleHead.getNext().getNext();
		}
		return copyHead;
		
	}
	
	public static void printNodes(Node val) throws Exception{
		Node temp = val;
		System.out.println("Node" + " "+ "Next" +" "+"Random");
		while(temp.getNext() != null){
			System.out.println(temp.getData()+" "+temp.getNext().getData()+" "+temp.getRandom().getData());
			temp = temp.getNext();
		}
		System.out.println(temp.getData()+" ");
	}

	public static void main(String[] args) throws Exception{
		Node list1 = new Node(1);
		Node a = new Node(2);
		list1.setNext(a);
		Node b = new Node(3);
		a.setNext(b);
		
		list1.setRandom(b);
		a.setRandom(b);
		
		printNodes(clone(list1));
		
		

	}

}
