package com.java.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class FindIntersectionOfTwoArrays {
	
	/**
	 * case 1 - when two arrays are unsorted
	 * Assume two lists, ‘aList1’ of size ‘m’ and ‘aList2’ of size ‘n’
	 * Algorithm Time Complexity: O(m) + O(n)*O(1) ~ O(m+n)
	 * Algorithm Space Complexity: O(m)  
	 * @param aList1
	 * @param aList2
	 * 
	 * pros:best algorithm when compared to all others provided one implements appropriate hashcode method
	 * cons:when the size of the data structure grows too high, it might lead to hash collisions
	 */
	
	public static void getIntersection(ArrayList<Integer> aList1, ArrayList<Integer> aList2){

	    Set<Integer> ht = new HashSet<Integer>();
	    
	    if(aList1.size() == 0 || aList2.size() == 0 ){
	       System.err.println("No intersection");;
	    }
	    
	    for(int i = 0 ; i < aList2.size(); i++){
	    	ht.add(aList2.get(i));
	    }
	               
	    for(int i = 0; i < aList1.size(); i++){
	        if(ht.contains(aList1.get(i))){
	        	System.out.println(aList1.get(i)+" is present in both lists");
	        
	        }
	     }   
	}
	
	/**
	 * We can have two index, which both starts at zero. Compare the two first elements of A and B.
	 *  If A[0] is greater than B[0], we increase index of B by one. If B[0] is greater than A[0], 
	 *  we increase index of A by one. If they are equal, we know an intersection has occurred, 
	 *  so add it to the list and increment index of A and B by one. Once either index reaches the end of A or B, 
	 *  we have found all the intersections of A and B.

	* The complexity of this approach is still O(m+n), but it does not requires any extra space that a hash table requires. 
	* The complexity is O(m+n) because in the worse case, there would be no intersection between the two arrays, 
	* and we need to increment first index a total of m times and increment second index a total of n times, which is a total of m+n times.
	 * @param aList1
	 * @param aList2
	 */
	
	public static void listIntersection(ArrayList<Integer> aList1, ArrayList<Integer> aList2){
		int len1 = aList1.size();
		int len2 = aList2.size();
		
		int i = 0, j = 0;
		
		while(i < len1 && j < len2){
			if(aList1.get(i) > aList2.get(j)){
				j++;
			}else if(aList1.get(i) < aList2.get(j)){
				i++;
			}else{
				System.out.println(aList1.get(i)+ " is present in both lists.");
				i++;
				j++;
			}
		}
		
	}
	
	
	public static void main(String[] args){
		ArrayList<Integer> aList1 = new ArrayList<Integer>();
		ArrayList<Integer> aList2 = new ArrayList<Integer>();
		aList1.add(1);
		aList1.add(2);
		aList1.add(3);
		aList1.add(4);
		aList2.add(3);
		aList2.add(4);
		aList2.add(6);
		//getIntersection(aList1, aList2);
		listIntersection(aList1, aList2);
		
	}

}
