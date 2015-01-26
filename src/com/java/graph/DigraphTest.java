package com.java.graph;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

public class DigraphTest<T> {

	static Digraph<Node<String>> graph;
	static NodeImpl<String> node1;
	static NodeImpl<String> node2;
	Map<T,Integer> result;

	@BeforeClass
	public static void setUp() throws FileNotFoundException {
		//for reading the file from maven resources folder
		//ClassLoader classLoader = getClass().getClassLoader();
		//File file = new File(classLoader.getResource("relations.txt").getFile());
		File relations = new File("/Users/robin/Documents/workspace/java_problems/src/com/java/graph/relations.txt");
		if(!relations.exists()) throw new FileNotFoundException("Relations file could not be found!!");
		graph = new Digraph<Node<String>>();
		System.out.println("@Before - setUp");
		Scanner scanner = new Scanner(relations);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] arr = line.split(" ");
			node1 = new NodeImpl<String>(arr[0]);
			node2 = new NodeImpl<String>(arr[1]);
			graph.add(node1, node2); 
	    	node1.addChildren(node2);
		}
		scanner.close();
	}
	
	@Test
	public void assertTotalNodeCount() {
		System.out.println("No of nodes in the graph is : "+graph.nodeCount());
		assertTrue(graph.nodeCount()>=10);
	}
    
	@Test
	public void assertChildrenCountForEachNode() {
		System.out.println("No of children in the graph" + graph.outDegree());
		result = new HashMap<T,Integer>();
		result = (Map<T, Integer>) graph.outDegree();
		for (T from: result.keySet()) {
			assertTrue(result.get(from)>=3);
		}
	}
	
	@Test
	public void checkCyclic() {
		assertFalse(graph.isDag());
	}
	
	
	


}
