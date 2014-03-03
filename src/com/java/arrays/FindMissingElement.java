/**
 * Given an array of integers and another arr with one of the elements 
 * removed from the first element from the first array, find the missing element. 
 * Make sure the space complexity and time complexity is linear time. 
 */

package com.java.arrays;

public class FindMissingElement {
	
	/**
	 * 
	 * The space complexity of this solution is constant O(1) since we only use one extra variable.
	 * Time complexity is O(N) because we perform a single pass from the arrays. 
	 * @param arr1
	 * @param arr2
	 * @return the value which is missing
	 */
	
	public static int findMissing(int[] arr1, int[] arr2){
		int result = 0;
		for(int i = 0; i < arr1.length; i++){
			result ^= arr1[i];
			System.out.println(i +" "+ result);
		}
		for(int i = 0; i < arr2.length; i++){
			result ^= arr2[i];
			System.out.println(i +" "+ result);
		}
		System.out.println("Result:  "+ result);
		return result;
	}

	public static void main(String[] args) {
		int[] arr1 = {4,1,0,2,9,6,8,7,5,3};
		int[] arr2 = {6,4,7,2,1,0,8,3,9};
		System.out.println(findMissing(arr1, arr2));

	}

}
