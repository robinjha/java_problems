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
		arraySize[stackSize*stackNum+pointer[stackNum]] = 0;
		pointer[stackNum]--;
		return value;
	}
	
	public boolean isEmpty(int stackNum){
		return pointer[stackNum] == -1;
		
	}
	
	public int peek(int stackNum){
		return arraySize[stackSize*stackNum+pointer[stackNum]];
	}
	
	
	public static void main(String[] args) throws Exception {
		
		int[] arr = {1,2,3,4,5,6,7,8,9};
		
		ThreeStacksUsingArray tsua = new ThreeStacksUsingArray();
		tsua.push(1,5);
		tsua.push(1,4);
		tsua.push(2,7);
		tsua.push(3,9);
		tsua.push(2,8);
		tsua.push(3,1);
		System.out.println("Popped value is : " + tsua.pop(1));
		System.out.println("Peeked value is :"+tsua.peek(1));
		
	}

}
