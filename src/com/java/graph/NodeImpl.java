package com.java.graph;

import java.util.TreeSet;
import java.util.List;
import java.util.Set;

public class NodeImpl<T> implements Node<T>,Comparable<Node>{
	
	private String name;
	private Set<Node<T>> children = new TreeSet<Node<T>>();
	
	public NodeImpl(String name){
		this.name = name;
	}
	
	@Override
	public String name() {
		return name;
	}

	@Override
	public Set<Node<T>> children() {
		return children;
	}
	
	public void addChildren(List<String> childs){
		for(Node<T> child: children){
			if(!children.contains(child)){
				children.add(child);
				
			}
		}
	}
	
	@Override
	/*public String toString() {
		return "NodeImpl [name=" + name + ", children=" + children + "]";
	}*/
	
	public String toString(){ 
		return name; 
	}
	
	
	public static void main(String[] args) {
		

	}

	@Override
	public int compareTo(Node arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
