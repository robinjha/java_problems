package com.java.graphs;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Digraph{
    private Bag<Integer>[] adj;
    private int V;
    private int E;
    
    public Digraph(int V){
    	if(V < 0) throw new IllegalArgumentException("Number needs to be positive");
    	this.V = V;
    	this.E = 0;
    	adj = new Bag[V];
    	for(int v = 0; v < V; v++){
    		adj[v] = new Bag<Integer>();
    	}
    	
    }
 
    public Digraph(ReadInput in){
        try{
            this.V = in.readInt();
            if(V < 0) throw new IllegalArgumentException("Cannot be non-negative.");
            adj = (Bag<Integer>[]) new Bag[V];
            for(int v = 0; v < V ; v++){
                adj[v] = new Bag<Integer>();
            }
            int E = in.readInt();
            if(E < 0) throw new IllegalArgumentException("Cannot be non-negative.");
            for(int e = 0; e < E ; e++){
                int v = in.readInt();
                int w = in.readInt();
                addEdge(v,w);
            }
        }catch(NoSuchElementException e){
            throw new InputMismatchException("Invalid input format");
        }
    }
    
    public void addEdge(int v, int w){
        if(v < 0 || v >= V) throw new IndexOutOfBoundsException("Not in bounds");
        if(w < 0 || w >= V) throw new IndexOutOfBoundsException("Not in bounds");
        adj[v].add(w);
    }

   public Iterable<Integer> adj(int v){
       return adj[v];
   }
   
   public int V() {
       return V;
   }

   public int E() {
       return E;
   }
   
   public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    
    public static void main(String[] args){
        ReadInput in = new ReadInput(args[0]);
        Digraph G = new Digraph(in);
        StdOut.println(G);
    }
    
}