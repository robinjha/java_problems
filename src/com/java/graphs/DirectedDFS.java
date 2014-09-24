package com.java.graphs;

public class DirectedDFS {
	
	private boolean[] marked;
	private int count;
	
	public DirectedDFS(Digraph G, int s){
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	
	public DirectedDFS(Digraph G, Iterable<Integer> sources){
		marked = new boolean[G.V()];
		for(int v: sources){
			if(!marked[v]) dfs(G,v);
		}
	}
	
	public void dfs(Digraph G, int v){
		count++;
		marked[v] = true;
		for(int w: G.adj(v)){
			if(!marked[w]) dfs(G,w);
		}
	}
	
	
	
	public boolean marked(int v){
		return marked[v];
	}
	
	public int count(){
		return count;
	}

	public static void main(String[] args) {
		ReadInput in = new ReadInput(args[0]);
		Digraph G = new Digraph(in);
		
		//add the sources from the command line
		/*Bag<Integer> sources = new Bag<Integer>();
		for(int i = 0; i < args.length; i++){
			int s = Integer.parseInt(args[i]);
			sources.add(s);
		}*/
		
		DirectedDFS dfs = new DirectedDFS(G, 1);
		
		for(int v = 0; v < G.V(); v++){
			if(dfs.marked(v)) StdOut.print(v + " ");
		}
		

	}

}
