package com.java.arrays;

import java.util.Arrays;

public class FindPairsOfThreeNumbersSumToZero {
	
	public static boolean containsDuplicates(int[] arr){
		for(int i = 1; i < arr.length; i++){
			if(arr[i] == arr[i-1]) return true;
		}
		return false;
	}
	
	
	/**
	 * runtime O(n^2)
	 * @param arr
	 */
	public static void printThreeNumbersAddingToZero(int[] arr){
		Arrays.sort(arr);
		if(containsDuplicates(arr)) throw new IllegalArgumentException("array contains duplicates");
		for(int i = 0; i < arr.length; i++){
			for(int j = i+1; j < arr.length; j++){
				int k = Arrays.binarySearch(arr, -(arr[i]+arr[j]));
				if(k > j) System.out.println(arr[i] + "  "+arr[j]+" "+arr[k]);
			}
		}
	}
	
	/**
	 * run time : O(n^2) since we execute the outer loop O(n) times and we execute the inner loop O(n) times
	 * @param arr
	 * @param sum
	 */
	public static void threeNumberSum(int[] arr, int sum){
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++){
			int left = i+1;
			int right = arr.length - 1;
			
			while(right > left){
				if(arr[i]+arr[left]+arr[right] == sum){
					System.out.println(arr[i]+" "+arr[left] +" "+ arr[right]);
					right--;
				}else if(arr[i]+arr[left]+arr[right] >sum){
					right--;
				}else{
					left++;
				}
			}
		}
	}

	public static void main(String[] args) {
		
		
		int[] arr = {2, 3, 1, -2, -1, 0, -3};
		//printThreeNumbersAddingToZero(arr);
		threeNumberSum(arr, -2);

	}

}
