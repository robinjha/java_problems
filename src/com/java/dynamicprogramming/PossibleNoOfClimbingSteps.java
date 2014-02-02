package com.java.dynamicprogramming;

public class PossibleNoOfClimbingSteps {

	public static int stepsPermutation(int stepCount){
		if(stepCount < 0) return 0;
		if(stepCount == 0) return 1;
		return (stepsPermutation(stepCount - 1)+stepsPermutation(stepCount - 2)+stepsPermutation(stepCount - 3));
	}
	
	public static int stepsPermutationDP(int stepCount, int[] perms){
		if(stepCount < 0) return 0;
		if(stepCount == 0) return 1;
		if(perms[stepCount] > -1) return perms[stepCount];
		perms[stepCount] = (stepsPermutationDP(stepCount - 1, perms)+stepsPermutationDP(stepCount - 2, perms)+stepsPermutationDP(stepCount - 3, perms));
		return perms[stepCount];
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			int[] vals = new int[10];
			for (int j = 0; j < vals.length; j++) {
				vals[j] = -1;
			}
			int count = stepsPermutation(i);
			int countDP = stepsPermutationDP(i, vals);
			System.out.println("Count :"+i + "****" + "Ways to Count: "+count );
			System.out.println("Count :"+i + "****" + "Ways to CountDP: "+countDP );
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
	}

}
