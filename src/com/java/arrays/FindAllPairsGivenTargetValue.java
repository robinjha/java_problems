/**
 * Given array of n integers and given a number X, find all the unique pairs of elements (a,b),
 *  whose summation is equal to X.
 *  
 *  
 *  We iterate only once through the array --> O(n) time
 *  Insertion and lookup time in Hash is O(1).
 *  Overall time is O(n), although it uses extra space in terms of hash.

 */

package com.java.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAllPairsGivenTargetValue {
	
	//this solution needs the array to be sorted
		@SuppressWarnings("unused")
		private static class Pairs{
			private int leftInt;
			private int rightInt;
			
			public Pairs(int rInt, int lInt){
				this.leftInt = lInt;
				this.rightInt = rInt;
			}
			
			public int getLeftInt() {
				return leftInt;
			}
			public void setLeftInt(int leftInt) {
				this.leftInt = leftInt;
			}
			public int getRightInt() {
				return rightInt;
			}
			public void setRightInt(int rightInt) {
				this.rightInt = rightInt;
			}
			@Override
			public String toString() {
				return "Pairs [leftInt=" + leftInt + ", rightInt=" + rightInt + "]";
			}
		}
		
	
	// this solution doesn't need the array to be sorted
	// starts with storing the complement of the number as the key
	// and the number as the value.
	//time complexity O(n) where n is the length of the string
	public static void findPairs(int[] numArr, int target){
		Map<Integer, Integer> numMap = new HashMap<Integer,Integer>();
		
		for(int i : numArr){
			if(numMap.containsKey(i)){
				System.out.println(i +" "+ numMap.get(i));
			}else{
				numMap.put(target - i, i); // storing the complement 
			}
			
		}
	}
	
	
	public static ArrayList<Pairs> getPairsAddingToValue(int[] arr, int target) throws Exception{
		if(arr.length == 0) throw new Exception("The array is empty");
		ArrayList<Pairs> pairs = new ArrayList<Pairs>();
		int start = 0;
		int end = arr.length-1;
		Pairs p = null;
		for(int i = 0; i < arr.length; i++){
			if(arr[start]+ arr[end] == target){
				if(start == end) break;
				p = new Pairs(arr[start], arr[end]);	
				pairs.add(p);
				start++;
				end--;
			}else if(arr[start]+arr[end] > target){
				end--;
			}else{
				start++;
			}
		}
		return pairs;
	}
	
	public static void printPairs(ArrayList<Pairs> pairList){
		for(Pairs p: pairList){
			System.out.println(p.toString());
		}
	}

	public static void main(String[] args) throws Exception {
		int[] arr = { 95, 5, 95, 5 }; //{3,2,6,2,0,5,3,8,7,10};
		Arrays.sort(arr);
		findPairs(arr, 100);
		printPairs(getPairsAddingToValue(arr,10));
	}

}
