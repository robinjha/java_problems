package com.java.dynamicprogramming;

public class CuttingTheRod {

	public static int splitRod(int[] prices, int totalLength){
		if(totalLength <= 0) return 0;

		int result = Integer.MIN_VALUE;

		for(int len = 0; len < totalLength; len++){
			result = Math.max(result, prices[len]+splitRod(prices, totalLength-len-1));
		}

		return result;
	}

	/**
	 * split Rod using DP. Precompute and put the values in the array
	 * @param prices
	 * @param totalLength
	 * @return
	 */
	public static int splitRodDP(int[] prices, int totalLength){
		if(totalLength <= 0) return 0;
		
		int[] costs = new int[totalLength+1]; // to save the costs of the cut
		costs[0] = 0; 
		
		for(int i = 1; i <= totalLength; i++){
			int result = Integer.MIN_VALUE;
			for(int j = 0; j < i ; j++){
				result = Math.max(result, prices[j]+prices[i-j-1]);
			}
			costs[i] = result;
		}
		
		
		return costs[totalLength];
	}
	
	public static int splitRod2(int[] prices, int n){
		int[] scores = new int[n+1];
		 for(int i = 1; i <= n; i++){
			 scores[i] = prices[i-1];
			 System.out.println("~~~~~~~~~~~");
			 for(int j = 0; j<=i/2; j++){
				 System.out.println(scores[i] + " "+ (scores[j]+scores[i-j]));
				 scores[i] = Math.max(scores[i], scores[j]+scores[i-j]);
			 }
		 }
		return scores[n];
	}

	public static void main(String[] args) {
		int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(splitRod(arr, 8));
		System.out.println(splitRod2(arr,8));

	}

}
