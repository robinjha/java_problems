package com.java.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * An example class for directed graphs.  
 * The node type can be specified.
 * There are no edge costs/weights.
 * 
 */
public class Digraph<T> {
    
    /**
     * The implementation here is basically an adjacency list, but instead
     * of an array of lists, a Map is used to map each vertex to its list of 
     * adjacent vertices.
     */   
    private Map<T,List<T>> neighbors = new HashMap<T,List<T>>();
    
    /**
     * String representation of graph.
     */
    public String toString () {
        StringBuffer s = new StringBuffer();
        for (T v: neighbors.keySet()) s.append("\n    " + v + " -> " + neighbors.get(v));
        return s.toString();                
    }
    
    /**
     * Add a vertex to the graph.  Nothing happens if vertex is already in graph.
     */
    public void add (T vertex) {
        if (neighbors.containsKey(vertex)) return;
        neighbors.put(vertex, new ArrayList<T>());
        
        
    }
    
    /**
     * True iff graph contains vertex.
     */
    public boolean contains (T vertex) {
        return neighbors.containsKey(vertex);
    }
    
    /**
     * Add an edge to the graph; if either vertex does not exist, it's added.
     * This implementation allows the creation of multi-edges and self-loops.
     */
    public void add (T from, T to) {
        this.add(from); 
        this.add(to);
        neighbors.get(from).add(to);
        
    }
    
    /**
     * Remove an edge from the graph.  Nothing happens if no such edge.
     * @throws IllegalArgumentException if either vertex doesn't exist.
     */
    public void remove (T from, T to) {
        if (!(this.contains(from) && this.contains(to)))
            throw new IllegalArgumentException("Nonexistent vertex");
        neighbors.get(from).remove(to);
    }
    
    /**
     * Report (as a Map) the out-degree of each vertex.
     */
    public Map<T,Integer> outDegree () {
        Map<T,Integer> result = new HashMap<T,Integer>();
        for (T v: neighbors.keySet()){
        	result.put(v, neighbors.get(v).size());
        	
        }
        return result;
    }
    
    /**
     * 
     */
    public List<Node<T>> nodesInTheGraph(){
    	List<Node<T>>
    	return 
    }
     
    /**
     * Report (as a Map) the in-degree of each vertex.
     */
    public Map<T,Integer> inDegree () {
        Map<T,Integer> result = new HashMap<T,Integer>();
        for (T v: neighbors.keySet()) result.put(v, 0);       // All in-degrees are 0
        for (T from: neighbors.keySet()) {
            for (T to: neighbors.get(from)) {
                result.put(to, result.get(to) + 1);           // Increment in-degree
            }
        }
        return result;
    }
    
    /**
     * Return total number of nodes in the graph 
     * @return
     */
    public int nodeCount(){
    	return neighbors.size();
    }
    
    /**
     * Report (as a List) the topological sort of the vertices; null for no such sort.
     */
    public List<T> topSort () {
        Map<T, Integer> degree = inDegree();
        // Determine all vertices with zero in-degree
        Stack<T> zeroVerts = new Stack<T>();        // Stack as good as any here
        for (T v: degree.keySet()) {
            if (degree.get(v) == 0) zeroVerts.push(v);
        }
        // Determine the topological order
        List<T> result = new ArrayList<T>();
        while (!zeroVerts.isEmpty()) {
            T v = zeroVerts.pop();                  // Choose a vertex with zero in-degree
            result.add(v);                          // Vertex v is next in topol order
            // "Remove" vertex v by updating its neighbors
            for (T neighbor: neighbors.get(v)) {
                degree.put(neighbor, degree.get(neighbor) - 1);
                // Remember any vertices that now have zero in-degree
                if (degree.get(neighbor) == 0) zeroVerts.push(neighbor);
            }
        }
        // Check that we have used the entire graph (if not, there was a cycle)
        if (result.size() != neighbors.size()) return null;
        return result;
    }
    
    /**
     * True iff graph is a dag (directed acyclic graph).
     */
    public boolean isDag () {
        return topSort() != null;
    }
    
    /**
     * Report (as a Map) the bfs distance to each vertex from the start vertex.
     * The distance is an Integer; the value null is used to represent infinity
     * (implying that the corresponding node cannot be reached).
     */
    public Map<T, Integer> bfsDistance (T start, int depth) {
        Map<T,Integer> distance = new HashMap<T,Integer>();
        // Initially, all distance are infinity, except start node
        for (T v: neighbors.keySet()) distance.put(v, null);
        distance.put(start, 0);
        // Process nodes in queue order
        Queue<T> queue = new LinkedList<T>();
        queue.offer(start);                                    // Place start node in queue
        while (!queue.isEmpty() && depth >= 0) {
            T v = queue.remove();
            int vDist = distance.get(v);
            
            // Update neighbors
            for (T neighbor: neighbors.get(v)) {
                if (distance.get(neighbor) != null) continue;  // Ignore if already done
                distance.put(neighbor, vDist + 1);
                queue.offer(neighbor);
            }
            depth--;
        }
        return distance;
    }
    
    
   /**
    * Find connections given depth. Gets all the nodes in the graph and runs 
    * bfs on them for the passed depth parameter. 
    * @param start - start node
    * @param depth - depth of the connections
    * @return
    */
  
@SuppressWarnings("unchecked")
public Map<Node<T>, Map<T,Integer>> findConnections(T start, int depth){
	   Map<T,Integer> distance = new HashMap<T,Integer>();
	   Map<T,Integer> connections = null;
	   Map<Node<T>, Map<T,Integer>> nodes = new HashMap<Node<T>, Map<T,Integer>>();
	  // List<Node<T>> vals = null;
	   
	   for (T v: neighbors.keySet()){
		   //vals = new ArrayList<Node<T>>(); 
		   connections = new HashMap<T,Integer>();
		   distance = bfsDistance(v, depth);
		   for(Map.Entry<T, Integer> entry : distance.entrySet()){
			   if(entry.getValue() != null && entry.getValue() <= depth && entry.getKey() != v){ // add the check to make sure the node itself is not added 
				  // vals.add((Node<T>) entry.getKey());
				   connections.put(entry.getKey(), entry.getValue());
			   }
		   }
		   nodes.put((Node<T>) v, connections);
	   }
	   
	   return nodes;
   }

/**
 * function traverses the graph and returns whether or not two people are "connected" 
 * and what "level" (or depth) the connection is within the graph. Returns the depth 
 * if they are connected, else returns -1.
 * @param node1
 * @param node2
 * @return depth of the connection, -1 if the connection doesn't exist
 */
@SuppressWarnings("unchecked")
public int connected(Node node1, Node node2){
	if(node1 == node2){
		return 0;
	}
	
	Map<T,Integer> distance = new HashMap<T,Integer>();
	
	for (T v: neighbors.keySet()) distance.put(v, null);
    distance.put((T) node1, 0);
	
 // Process nodes in queue order
    Queue<T> queue = new LinkedList<T>();
    queue.offer((T) node1);                                    // Place start node in queue
    while (!queue.isEmpty()) {
        T v = queue.remove();
        int vDist = distance.get(v);
        
        // Update neighbors
        for (T neighbor: neighbors.get(v)) {
            if (distance.get(neighbor) != null) continue;  // Ignore if already done
            if(neighbor == node2) return vDist+1;
            distance.put(neighbor, vDist + 1);
            queue.offer(neighbor);
        }
       
    }
	return -1;
}

    
    /**
     * Main program (for testing).
     */
    public static void main (String[] args) {
        // Create a Graph with String nodes
 
    	Digraph<Node<String>> graph = new Digraph<Node<String>>();
    	NodeImpl<String> A = new NodeImpl<String>("A");
    	NodeImpl<String> B = new NodeImpl<String>("B");
    	NodeImpl<String> C = new NodeImpl<String>("C");
    	NodeImpl<String> D = new NodeImpl<String>("D");
    	NodeImpl<String> E = new NodeImpl<String>("E");
    	NodeImpl<String> F = new NodeImpl<String>("F");
    	NodeImpl<String> G = new NodeImpl<String>("G");
    	NodeImpl<String> H = new NodeImpl<String>("H");
    	graph.add(A, B); 
    	A.addChildren(B);
        graph.add(A, C); 
        A.addChildren(C);
        graph.add(A, D);
        A.addChildren(D);
        graph.add(B, C); 
        graph.add(B, D); 
        graph.add(C, D);
        graph.add(C, E); 
        graph.add(E, F);
        graph.add(F, G);
        graph.add(G,D);//added
        graph.add(D,A);//added
        System.out.println("The current graph: " + graph);
        System.out.println("In-degrees: " + graph.inDegree());
        System.out.println("Out-degrees: " + graph.outDegree());
        System.out.println("A topological sort of the vertices: " + graph.topSort());
        System.out.println("The graph " + (graph.isDag()?"is":"is not") + " a dag");
        System.out.println("BFS distances starting from " + 0 + ": " + graph.bfsDistance(A,2));
        graph.add(E,B); // create cycle
        System.out.println("Cycle created");
        System.out.println("The current graph: " + graph);
        System.out.println("A topological sort of the vertices: " + graph.topSort());
        System.out.println("The graph " + (graph.isDag()?"is":"is not") + " a dag");
        System.out.println("Find connections for depth" + graph.findConnections(A, 2));
        System.out.println("Is there a connection between the 2 nodes ? " + graph.connected(A, H));
        System.out.println("Children is : " + A.getChildrenCount());
    }
}

