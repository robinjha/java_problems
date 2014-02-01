package com.java.graphs;

public class DigraphAdjMatrix {

	private int E;
	private int V;
	
	public DigraphAdjMatrix(int V, int E) {
		while(this.E != E){
			int v = (int) (V * Math.random());
			int w= (int) (V*Math.random());
			addEdge(v,w);
		}
		
	}

	public void addEdge(int v2, int w) {
		
		
	}

	public static void main(String[] args) {
		int V = Integer.parseInt(args[0]);
		int E = Integer.parseInt(args[1]);
		DigraphAdjMatrix dAdjMatrix = new DigraphAdjMatrix(V, E);
		StdOut.println(dAdjMatrix);

	}

}
