/**
 * 
 */
package com.java.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;


/**
 * @author robin
 *
 */
public class GraphImpl implements Graph {
	
	private int edges;
	private int vertices;
	private HashMap<String, Node> myVertices;  //name to vertex 
	private HashMap<Node, TreeSet<Node>> myAdjList; //vertex to adjList
	
	private static final TreeSet<Node> EMPTY_SET = new TreeSet<Node>();
	public static final int INFINITY = Integer.MAX_VALUE;
	
	public GraphImpl(){
		edges = vertices = 0;
		myAdjList = new HashMap<Node, TreeSet<Node>>();
		myVertices = new HashMap<String, Node>();
	}
	
	/**
	 * if vertex doesn't exist yet, add it
	 * @param name
	 * @return
	 */
	public Node addNode(String name)  {
		Node i;
		i = myVertices.get(name);
		if(i == null){
			i = new NodeImpl(name);
			myVertices.put(name, i);
			myAdjList.put(i, new TreeSet<Node>());
			vertices += 1;
		}
		return i;
	}
	
	/**
	 * returns the node matching the name
	 * @param name - string name of the node in the graph
	 * @return - the node with this name, if it is null returns null
	 */
	public Node getNode(String name)  {
		return myVertices.get(name);
	}
	
	/**
	 * function to check if the node is in the graph, 
	 * @param name
	 * @return
	 */
	public boolean hasNode(String name)  {
		return myVertices.containsKey(name);
	}
	
	/**
	 * function to check if there is an edge from source to dest.
	 * 
	 * @param source node 
	 * @param dest node 
	 * @return true if there is an edge from source to dest, false otherwise
	 */
	public boolean hasEdge(String source, String dest)  {
		Node n1 = myVertices.get(source);
		Node n2 = myVertices.get(dest);
		if(n1 == null || n2 == null) return false;
		System.out.println(myAdjList.get(n1).contains(n2));
		return myAdjList.get(n1).contains(n2);
	}
	
	/**
	 * add edge from source to dest
	 * @param source
	 * @param dest
	 */
	public void addEdge(String source, String dest)  {
		Node n1, n2;
		if(hasEdge(source, dest))return;
		edges +=1;
		if((n1 = getNode(source)) == null)
			n1 = addNode(source);
		if((n2 = getNode(dest)) == null)
			n2 = addNode(dest);
		myAdjList.get(n1).add(n2);
	}
	
	/**
	 * returns an iterator over the neighbors of a node
	 * @param n - the node
	 * @return - empty set if the node is not present in the graph, else iterator over the collection of vertices 
	 */
	public Iterable<Node> adjacentTo(Node n){
		if(!myAdjList.containsKey(n)) return EMPTY_SET;
		return myAdjList.get(n);
	}
	
	public Iterable<Node> getVertices(){
		return myVertices.values();
	}
	
	public int numVertices(){
		return vertices;
	}
	
	public int numEdges(){
		return edges;
	}
	
	/*
	 * Returns adjacency-list representation of graph
	 */
	public String toString() {
		String s = "";
		for (Node v : myVertices.values()) {
			s += v + ": ";
			for (Node w : myAdjList.get(v)) {
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}



	/**
	 * returns an iterator over the neighbors of a node
	 * @param name takes in the name of the node
	 * @return - empty set if the node is not present in the graph, else iterator over the collection of vertices
	 */
	public Iterable<Node> adjacentTo(String name){
		Node n = getNode(name);
		if(n == null) return EMPTY_SET;
		return myAdjList.get(getNode(name));
	}
	
   
   /**
    * 
    * @param node
    * @param depth
    * @return
    */
   public Map<Node, List<Node>> findConnections(Node node, int depth)  {
	return null;
	   
   }
   
   /**
    * 
    * @param node1
    * @param node2
    * @return
    */
   public int connected(Node node1, Node node2)  {
	return 0; 
   }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GraphImpl G = new GraphImpl();
		G.addEdge("A", "B");
		G.addEdge("A", "C");
		G.addEdge("B", "C");
		G.addEdge("C", "D");
		G.addEdge("D", "E");
		G.addEdge("D", "G");
		G.addEdge("E", "G");
		G.addNode("H");
		
		// print out graph
		
		// A - > B,C
		// B -> C
		// C -> D
		// D -> E, G
		// 
		//
		System.out.println(G);
		
		// print out graph again by iterating over vertices and edges
		for (Node v : G.getVertices()) {
			System.out.print(v + ": ");
			System.out.println(G.adjacentTo(v.name()));
			for (Node w : G.adjacentTo(v.name())) {
				System.out.print(w + " ");
			}
			System.out.println();
		}

	}

}
