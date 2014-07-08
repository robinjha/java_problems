package com.java.arrays;

import java.util.Arrays;

public class RemoveElementFromArrayAndShiftElements {
	
	/**
	 * time complexity is O(n) where n is the lenght of the arr. 
	 * @param sortedArr
	 * @param value
	 * @return
	 */
	public static int[] removeElements(int[] sortedArr, int value){
		int startIndex = 0;
		for(int i = 0; i < sortedArr.length; i++){
			if(sortedArr[i] != value){
				sortedArr[startIndex++] = sortedArr[i];
				//sortedArr[i] = 0;
			}
		}
		return sortedArr;
	}
	
	public static int[] removeDuplicateElements(int[] sortedArr, int value){
		
		return sortedArr;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,5,5,6,7,8};
		//System.out.println(removeElements(arr, 5));
		System.out.println(Arrays.toString(removeElements(arr, 5)));
	}

}
