package com.java.collection.Stacks;

public class ThreeStacksUsingArray {
	public int stackSize = 100;
	public int[] arraySize = new int[3*stackSize];
	public int[] pointer = {-1, -1, -1};
	
	public void push(int stackNum, int value) throws Exception{
		//check if it is full
		if(pointer[stackNum] > stackSize){
			throw new Exception("We have run out of space!!");
		}
		pointer[stackNum]++;
		arraySize[stackSize*stackNum+pointer[stackNum]] = value;
	}
	
	public int pop(int stackNum) throws Exception{
		if(pointer[stackNum] == -1){
			throw new Exception("The stack is empty and there is nothing to pop!");
		}
		int value =  arraySize[stackSize*stackNum+pointer[stackNum]];
		arraySize[stackSize*stackNum+pointer[stackNum]]--;
		return value;
	}
	
	public boolean isEmpty(int stackNum){
		
	}
	
	public peek(int stackNum){
		
	}
	
	
	public static void main(String[] args) {
		
		

	}

}
