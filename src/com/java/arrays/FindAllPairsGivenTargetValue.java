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

import java.util.HashMap;
import java.util.Map;

public class FindAllPairsGivenTargetValue {
	
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

	public static void main(String[] args) {
		int[] arr = {3,2,6,2,0,5,3,8,7,10};
		findPairs(arr, 10);
	}

}
