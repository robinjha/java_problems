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
		boolean var = false;
		Arrays.sort(values);
		System.out.println("Sorted Array is :" + Arrays.toString(values));
		int i = 0, j = values.length -1;
		while(i < j){
			if(values[i]+values[j] == target){
				System.out.println("The values are :" +values[i] +" and "+ values[j]);
				i++;
				j--;
			}else if(values[i]+values[j] > target){
				j--;
			}else{
				i++;
			}
		}
		
		return var;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrValues = new int[]{1,4,2,3,8,6,5,7,12};
		int target = 12;
		checkTargetValueMatch(arrValues, target);
	}
	

}
