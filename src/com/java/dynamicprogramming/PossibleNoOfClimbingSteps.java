package com.java.dynamicprogramming;

public class PossibleNoOfClimbingSteps {

	public static int stepsPermutation(int stepCount){
		int[] steps = new int[stepCount];
		if(stepCount == 0) return 0;
		if(stepCount == 1) return 1;
		return (stepsPermutation(stepCount - 1)+stepsPermutation(stepCount - 2));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stepsPermutation(5));
	}

}
