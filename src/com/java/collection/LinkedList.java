package com.java.collection;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
	
	private Node<T> head;
	

	public boolean isEmpty(){
		return head == null;
	}
	
	public void addFirst(T item){
		head = new Node<T>(item, head);
	}
	
	public T getFirst(){
		if(head == null) throw new NoSuchElementException();
		return head;
	}
	
	
	public T removeFirst(){
		if(head == null) throw new OperationNotPermittedException();
		Node tmp = getFirst();
		head = head.next;
		return tmp;
	}
	
	/**
	 * 
	 * @param item - to be inserted in the linkedlist
	 * adds the element to the end of the list
	 */
	
	public void addLast(T item){
		if(head == null)
			addFirst(item);
		else{
			Node tmp;
			while(head.next ! = null){
				tmp = tmp.next;
			}
			tmp.next = new Node(item, null);
		}
	}
	
	/**
	 * 
	 * @return - last node of the linked list
	 */
	public T getLast(){
		Node tmp = head;
		if(head == null) throw new NoSuchElementException();
		while(tmp.getNext() != null){
			tmp = tmp.setNext();
		}
		return tmp;
		
	}
	
	/**
	 * removes all the elements from the list
	 */
	public void clear(){
		head = null;
	}
	
	public boolean contains(T key){
		Node tmp = head;
		while(!tmp.getData().equals(key) || tmp.getNext() == null){
			tmp = tmp.getNext();
		}
		
	}
	
	public T get(int pos){
		
	}
	
	public String toString(){
		
	}
	
	public void insertAfter(T key, T toInsert){
		
	}
	
	public void insertBefore(T key, T toInsert){
		
	}
	
	public void remove(T key){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
