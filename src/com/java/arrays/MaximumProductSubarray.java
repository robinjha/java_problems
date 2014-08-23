package com.java.arrays;

/**
 * 
 * @author robin
 * Time Complexity: O(n)
    Auxiliary Space: O(1)
    
    Given an array that contains both positive and negative integers, find the product of the maximum product subarray. 
    Expected Time complexity is O(n) and only O(1) extra space can be used.
 */
public class MaximumProductSubarray {
	
	public static int maxProdSubArray(int[] arr){
		int start = 1;
		int end = 1;
		int max = 1;
		
		for(int i =0; i < arr.length; i++){
			
			if(arr[i] > 0){
				end = end * arr[i];
				start = min(start * arr[i], 1);
			}else if(arr[i] == 0){
				end = 1;
				start = 1;
			}else{
				int temp = end;
				end = max(start*arr[i],1);
				start = temp * arr[i];
			}
			
			if(max < end){
				max = end;
			}
			
		}
		
		
		return max;
	}
	
	public static int min(int x, int y){
		return(x > y)?y:x;
	}
	
	public static int max(int x, int y){
		return(x < y)?y:x;
	}

	public static void main(String[] args) {
		int[] arr = {6, -3, -10, 0, 2};
		System.out.println("Max Product is : " + 
		maxProdSubArray(arr));
	}

}
