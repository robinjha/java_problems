package com.java.dynamicprogramming;

import java.util.Arrays;

public class MagicIndex {
	
	public static int magicIndex(int[] arr){
		for(int i = 0 ; i < arr.length; i++){
			if(arr[i] == i){
				return i;
			}
		}
		return -1;
	}
	
	public static int magicIndexRecurse(int[] arr, int index){
		if(index == arr.length) return 0;
		if(arr[index] == index)return index;
		return magicIndexRecurse(arr, index+1);
	}
	
	public static int magicIndexOptimized(int[] arr, int start, int end){
		if(end >= arr.length||end < start || start < 0)
			return -1;
		
		int mid = (start+end)/2;
		if(arr[mid] == mid)
			return mid;
		else if(arr[mid] > mid)
			return magicIndexOptimized(arr, start, mid-1);
		else
			return magicIndexOptimized(arr, mid+1, end);
	}

	public static void main(String[] args) {
		int[] vals = {-10,-5,2,4,6};
		 Arrays.sort(vals);
		//System.out.println(magicIndex(vals));
		//System.out.println(magicIndexRecurse(vals, 0));
		System.out.println(magicIndexOptimized(vals, 0, vals.length-1));
	}

}
