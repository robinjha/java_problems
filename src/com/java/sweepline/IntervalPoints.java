package com.java.sweepline;

public class IntervalPoints implements Comparable<IntervalPoints>{
	
	public IntervalPoints(int value, PointType type) {
		this.value = value;
		this.type = type;
	}
	
	public int compareTo(IntervalPoints point){
		if(point.value == this.value){
			return this.type.ordinal() < point.type.ordinal() ? - 1 : 1;
		}else{
			return this.value < point.value ? -1 : 1;
		}
	}
	
	public enum PointType{
		START, INTSTART, INTEND, END
	}
	
	private int value;
	public PointType type;
	
	

}
