package com.java.dynamicprogramming;

public class Coins {
	
	
	public static int waysForCoinChange(int[] arr, int val){
		if(val <= 0)
			return 0;
		else if(val == 1)
			return 1;
		else{
			return waysForCoinChange(arr, val - 1) + waysForCoinChange(arr, val - 2) + waysForCoinChange(arr, val - 3);
		}
	}

	public static void main(String[] args) {
		int[] denominations = {1,2,3};
		System.out.println(waysForCoinChange(denominations, 5));

	}

}
