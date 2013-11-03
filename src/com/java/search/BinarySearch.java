package com.java.search;

/**
 *@author robin jha
 *@date 09/02/2013
 *
 */
public class BinarySearch {
	
	/**
	 * 
	 * @param a - an array of ints
	 * @param key
	 * @return value of the index where the key is found
	 */
	public static int binarySearch(int[] a, int key){
		int start = 0, end = a.length -1, mid = 0;
		while(start <= end){
			mid = start + (end - start)/2;
			if(key > a[mid]){
				start = mid + 1;
			}
			else if (key < a[mid]){
				end = mid -1;
			}
			else
				return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,4,5,6,7,8,9,10,11};
		int key = 4;
		int value = binarySearch(a,key);
		if(value != -1){
			System.out.println("The key " +key +" was found at index:" + value);
		}else{
			System.out.println("The key values was not found:" + value);
		}

	}

}
