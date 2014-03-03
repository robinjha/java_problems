/**
 * maximum subarray problem
 * http://en.wikipedia.org/wiki/Maximum_subarray_problem
 * 
 */

package com.java.arrays;

public class LargestContinuousSum {
	
	public static void maxSum(int[] arr){
		int maxSum=Integer.MIN_VALUE, maxEndIndex = 0, cumSum = 0, maxStartIndex = 0, maxCurrIndex=0;
		cumSum += arr[0];
		for(int i = 0; i < arr.length; i++){
			cumSum += arr[i];
			if(cumSum > maxSum){
				maxSum = cumSum;
				maxStartIndex = maxCurrIndex;
				maxEndIndex = i;
			}else if(cumSum < 0){
				cumSum = 0;
				maxCurrIndex = i+1;
			}
		}
		 System.out.println("Max sum : "+maxSum);
		 System.out.println("Max start index : "+maxStartIndex);
		 System.out.println("Max end index : "+maxEndIndex);
	}
	
	/**
	 * runs in O(n) time and O(1) space
	 * @param arr
	 * @return the max value
	 */
	public static int largestContinuousSum(int[] arr){
		int maxSum = 0, currentSum = 0;
		if(arr.length==0)
			return 0; 
		maxSum = currentSum = arr[0] ;
		for(int i: arr){
			currentSum=Math.max(currentSum+i, i);
			maxSum= Math.max(currentSum, maxSum);
		}

		return maxSum ;
	}

	public static void main(String[] args) {
		int[] arr = {-11,4,6,-18,9,-8};//{-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
		maxSum(arr);
		System.out.println("Max value :" +largestContinuousSum(arr));
	}

}
