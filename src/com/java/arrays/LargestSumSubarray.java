package com.java.arrays;

/**
 * 
 * @author robin
 * program to find the sum of contiguous subarray within a one-dimensional 
 * array of numbers which has the largest sum
 * 
 * KadaneÕs Algorithm
 *
 */
public class LargestSumSubarray {
	
	public static int[] largestSumArray(int[] arr){
		int[] a = new int[arr.length];
		
		int start = 0;
		int end = 0;
		
		for(int i = 0; i < arr.length; i++){
			
			end = end+arr[i];
			
			if(end < 0){
				end = 0;
			}else if(end > start){
				
				start = end;
			}else{
				start = 0;
				end = 0;
			}
			
		}
		System.out.println("max : " + start);
		return arr;
	}
	
	public static void main(String[] args){
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, 3};
		largestSumArray(arr);
	}

}
