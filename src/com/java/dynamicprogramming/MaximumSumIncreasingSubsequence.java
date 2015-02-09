package com.java.dynamicprogramming;



public class MaximumSumIncreasingSubsequence {
	
	//{1,101,2,3,100,4,5}
	
	/**
	 * time complexity - O(n^2)
	 * @param arr
	 * @param len
	 * @return
	 */
	public static int maxSum(int[] arr, int len){
		if(arr.length == 0) return 0; //base case : no elements
		if(arr.length == 1) return arr[0]; // base case: 1 element
		
		int[] max = new int[len];
		
		for(int j = 0; j < arr.length; j++){
			max[j] = arr[j];
		}
		
		int maxSoFar = 0, res = 0;
		for(int i=1; i < arr.length; i++){
			System.out.println("~~~~~~~~~~");
			for(int j=0; j<i ; j++){
				System.out.println(arr[i] +" "+ arr[j]);
				if(arr[i] > arr[j] && max[i] < arr[i]+max[j]){
					max[i] = arr[i] + max[j];
					System.out.println("Max:"+max[i]);
				}
			}
			
		}
		for(int j=0;j<len;j++){
			if(maxSoFar < max[j]){
				maxSoFar = max[j];
			}
		}
		
		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] arr = {1,101,2,3,100,4,5};
		System.out.println(maxSum(arr, 7));

	}

}
