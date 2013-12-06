package com.java.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

	static boolean duplicates(final int[] zipcodelist)
	{
	  Set<Integer> lump = new HashSet<Integer>();
	  for (int i : zipcodelist)
	  {
	    if (lump.contains(i)) return true;
	    lump.add(i);
	  }
	  return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,2,3,3,4,5,5,6};
		System.out.println(duplicates(arr));
	}

}
