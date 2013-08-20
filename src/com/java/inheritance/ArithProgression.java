package com.java.inheritance;

public class ArithProgression extends Progression{
	
	protected long inc;
	
	ArithProgression(){
		this(1);
	}
	
	ArithProgression(long increment){
		inc = increment;
	}
	
	protected long nextValue(){
		curr+=inc;
		return curr;
	}

}
