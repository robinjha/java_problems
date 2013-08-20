package com.java.inheritance;

public class GeomProgression extends Progression{
	
	GeomProgression(){
		this(2);
	}
	
	GeomProgression(long base){
		first = base;
		curr = first;
	}
	
	protected long nextValue(){
		curr*=first;
		return curr;
	}
}
