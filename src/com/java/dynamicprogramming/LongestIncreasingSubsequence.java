package com.java.dynamicprogramming;

public class LongestIncreasingSubsequence {
	
/*	public static int lis(int[] arr, int max_so_far, int arrLen){
		//base case
		if(arrLen == 1){
			return 1;
		}
		
		int res = 1, max_ending_here = 1;
		for(int i = 1; i < arrLen ; i++){
			res = lis(arr, max_so_far, i);
			if(arr[i-1] < arr[arrLen-1] && res+1 > max_ending_here)
				max_ending_here = res+1;
		}
		
		if(max_so_far < max_ending_here)
			max_so_far = max_ending_here;
		
		return max_ending_here;
	}
	
	static int lis(int[] arr, int arrLen){
		
		int max = 1;
		return lis(arr, arrLen, max);
	}*/
	
	public static int longestIncSubS(int[] arr){
		int maxLen = 1, bestEnd = 0;
		int[] DP = new int[arr.length];
		int[] prev = new int[arr.length];
		DP[0] = 1;
		prev[0] = -1;
		
		for(int i = 1; i < arr.length; i++){
			DP[i] = 1;
			prev[i] = -1;
			
			for(int j = i-1; j >=0; j--){
				if(DP[j] + 1 > DP[i] && arr[j] < arr[i]){
					DP[i] = DP[j] + 1;
					prev[i] = j;
				}
			}
			
			if(DP[i] > maxLen){
				bestEnd = i;
				maxLen = DP[i];
			}
		}
		
		for(int k = 0; k < prev.length; k++){
			System.out.print("\t" + prev[k]);
		}
		System.out.println();
		return maxLen;
	}

	public static void main(String[] args) {
		int arr[] = {10,22,9,33,21,50,41,60};
		System.out.println("Longest Increasing subsequence :" +  longestIncSubS(arr));

	}

}
