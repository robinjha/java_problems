package com.java.graph;

import java.util.HashSet;
import java.util.Set;

public class NodeImpl<T extends Comparable<T>> implements Node<T>{
	
	private T name;
	private Set<Node<T>> children = new HashSet<Node<T>>();
	
	public NodeImpl(T name){
		this.name = name;
	}
	
	public NodeImpl(Node<T> parent, Node<T> child){
		this.children.add(child);
	}

	public Set<Node<T>> children() {
		return children;
	}
	
	public void addChildren(Node<T> child){
		children.add(child);
	}

	public int getChildrenCount(){
		return this.children.size();
	}
	
	public int compareTo(T value) {
		return this.name.compareTo(name);
	}

	public T name() {
		return this.name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodeImpl<?> other = (NodeImpl<?>) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  name.toString();
	}
	

}
