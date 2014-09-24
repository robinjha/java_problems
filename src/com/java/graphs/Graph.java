package com.java.graphs;

public class Graph {
	
	private int V;
	private int E;
	private Bag<Integer>[] adj;
	
	
	public Graph(ReadInput in){
		this.V = in.readInt();
		adj = new Bag[V];
		for(int v = 0; v < V; v++){
			adj[v] = new Bag<Integer>();
		}
		int E = in.readInt();
		for(int e = 0; e < E; e++){
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}
	
	

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	public String toString(){
		StringBuilder s = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		s.append(V + " vertices, " + E + " edges " + NEWLINE);
		for(int v = 0; v < V; v++){
			s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
		}
		return s.toString();
	}


	public static void main(String[] args) {
		ReadInput in = new ReadInput(args[0]);
		Graph G = new Graph(in);
		StdOut.println(G);
	}

}
