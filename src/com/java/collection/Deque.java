package com.java.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    
    private Node<Item> head;
    private int N;
    
    private static class Node<Item>{
		private Item item;
        private Node<Item> next;
        
        public Node(Item item2, Node<Item> obj) {
			item = item2;
			next = obj;
		}

		public Node() {
			
		}
    } 
   
   
    
   public Deque()                     // construct an empty deque
   {
       head = null;
       N = 0;
   }
   
   public boolean isEmpty()           // is the deque empty?
   {
       return head == null;
   }
   
   public int size()                  // return the number of items on the deque
   {
       return N;
   }
   
   public void addFirst(Item item)    // insert the item at the front
   {
       Node<Item> old = head;
       head = new Node<Item>();
       head.item = item;
       head.next = old;
       N++;
   }
   
   public void addLast(Item item)     // insert the item at the end
   {
       if(head == null)addFirst(item);
       else{
           Node<Item> tmp = head;
           while(tmp.next != null){
               tmp = tmp.next;
           }
           tmp.next = new Node<Item>(item,null);
       }
       N++;
   }
       
   public Item removeFirst()          // delete and return the item at the front
   {
       if(head == null) throw new UnsupportedOperationException();
       head = head.next;
       return head.item;
   }
       
   public Item removeLast()           // delete and return the item at the end
   {
       Node tmp = head;
       Node prev = null;
       if(head == null) throw new UnsupportedOperationException();
       while(tmp.next != null){
           prev = tmp.next;
           tmp = head.next;
       }
       prev.next = tmp.next;
       return (Item)prev.next  ;
   }
   
   public Iterator<Item> iterator()   // return an iterator over items in order from front to end
   {
       return new DequeIterator<Item>(head);
   }
   
   private class DequeIterator<Item> implements Iterator<Item>{
       private Node<Item> current;
       
       public DequeIterator(Node<Item> first){
           current = first;
       }
       
       public boolean hasNext(){
           return current!=null;
       }
       
       public void remove(){
           throw new UnsupportedOperationException();
       }
       
       public Item next(){
           if(!hasNext()) throw new NoSuchElementException();
           Item item = current.item;
           current = current.next;
           return item;
           
       }
   }
}
