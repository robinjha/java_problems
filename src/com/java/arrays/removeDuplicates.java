package com.java.arrays;

import java.util.HashMap;

public class removeDuplicates {

	public static void main(String[] args) {
		HashMap<Integer, Integer> hm = new HashMap();
		int[] a = {0,5,9,5,6,7,6,9};

		/*
		 * iteration takes o(N) time  
		 */
		for(int i: a){
			hm.put(i, i);
		}
		
		for(Integer i : hm.keySet()){
			System.out.println(i);
		}

	}

}
