/**
 * Given an array of ints, find all pairs that add up to a target value
 * author: robin
 * date: 09/30/2013
 */

package com.java.arrays;

import java.util.Arrays;

public class FindTargetValue {

	/**
	 * @param args
	 */
	
	public static boolean checkTargetValueMatch(int[] values, int target){
		if(values.length == 0 || values == null){
			
		}
		boolean var = false;
		Arrays.sort(values);
		System.out.println("Sorted Array is :" + Arrays.toString(values));
		int i = 0, j = values.length -1;
		while(i < j){
			if(values[i]+values[j] == target){
				System.out.println("The values are :" +values[i] +" and "+ values[j]);
				//i++;
				//j--;
				return true;
			}else if(values[i]+values[j] > target){
				j--;
			}else{
				i++;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrValues = new int[]{3,2,6,2,0,5,3,8,7,10};
		int target = 10;
		System.out.println(checkTargetValueMatch(arrValues, target));
	}
	

}
