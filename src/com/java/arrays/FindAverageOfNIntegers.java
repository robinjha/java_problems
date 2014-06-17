/**
 * 
 * Given a list of 1000 integers, find the number within this list that
 * is closest to the average value of the integers.
 */

package com.java.arrays;

public class FindAverageOfNIntegers {
	
	public static double findNumClosestToAvg(int[] arr){
		int theAccumulator = 0;

		int avg = 0;

		for (int theCounter = 0; theCounter < arr.length; theCounter++){

			theAccumulator += arr[theCounter];
		}
		avg = theAccumulator/arr.length;
		
		int start = 0, end = arr.length -1 , mid = 0;
		
		while(start <= end){
			mid = start + (end - start)/2;
			if(avg > arr[mid]){
				start = mid + 1;
			}else if(avg < arr[mid]){
				end = mid - 1;
			}else{
				return avg;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[1000] ;//{1,2,3,4,5,6,7,8,9,10,11};
		for(int i = 0; i < 1000; i++){
			nums[i] = i;
		}
		System.out.println(findNumClosestToAvg(nums));

	}

}
