/**
 * this is the same solution as the one used for finding missing element. 
 * Space and time complexity are the same. 
 */
package com.java.arrays;

public class FindRepeatingElement {
	
	public static int findRepeating(int[] arr1, int[] arr2){
		int result = 0;
		for(int i = 0 ; i < arr1.length; i++){
			result ^= arr1[i];
		}
		for(int j = 0; j < arr2.length; j++){
			result ^= arr2[j];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr1 = {1,3,2};
		int[] arr2 = {2,3,1,2};
		System.out.println(findRepeating(arr1, arr2));

	}

}
