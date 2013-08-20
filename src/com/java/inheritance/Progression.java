package com.java.inheritance;

public class Progression {

	protected long first;
	protected long curr;
	
	Progression(){
		curr = first = 0;
	}
	
	protected long firstValue(){
		curr = first;
		return curr;
	}
	
	protected long nextValue(){
		return ++curr;
	}
	
	public void printProgression(int n){
		System.out.println(firstValue());
		for(int i = 2; i <= n ; i++)
			System.out.println(" " + nextValue());
		System.out.println();
	}
}
