package com.java.designquestions.CallCenter;

public enum Level {
	Respondent(0),
	Manager(1),
	Director(2);
	
	private int val;
	private Level(int v){
		val = v;
	}
	
	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
}
